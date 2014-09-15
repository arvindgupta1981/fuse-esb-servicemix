package rd.arv.consumer;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageConsumer;
import javax.jms.Session;
import javax.jms.TextMessage;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class SimpleConsumer {
	
	private static final Log LOG = LogFactory.getLog(SimpleConsumer.class);
	private static final Boolean NON_TRANSACTED = false;
	private static final String CONNECTION_FACTORY_NAME = "myJmsFactory";
	private static final String DESTINATION_NAME = "queue/simple";
	private static final int MESSAGE_TIMEOUT_MILLISECONDS = 120000;
	
	public static void main(String[] args) {
		Connection connection = null;
		
		try {
			Context  context = new InitialContext();
			ConnectionFactory connectionFactory = (ConnectionFactory) context.lookup(CONNECTION_FACTORY_NAME);
			Destination destination = (Destination) context.lookup(DESTINATION_NAME);
			connection = connectionFactory.createConnection();
			Session session = connection.createSession(NON_TRANSACTED, Session.AUTO_ACKNOWLEDGE);
			MessageConsumer consumer = session.createConsumer(destination);
			LOG.info("Start consuming messages from " + destination.toString() + " with " + MESSAGE_TIMEOUT_MILLISECONDS + "ms timeout");
			// Synchronous message consumer
			int i = 1;
			while (true) {
				Message message = consumer.receive(MESSAGE_TIMEOUT_MILLISECONDS);
				if (message != null) {
					if (message instanceof TextMessage) {
						String text = ((TextMessage) message).getText();
						LOG.info("Got " + (i++) + ". message: " + text);
					}
				} else {
					break;
				}
			}
			consumer.close();
			session.close(); 
		} catch (NamingException e) {
			e.printStackTrace();
		} catch (JMSException e) {
			e.printStackTrace();
		} finally {
			// Cleanup code
			// In general, you should always close producers, consumers,
			// sessions, and connections in reverse order of creation.
			// For this simple example, a JMS connection.close will
			// clean up all other resources.
			if (connection != null) {
				try {
					connection.close();
				} catch (JMSException e) {
					LOG.error(e);
				}
			}
		}
		
	}
}
