package rd.arvind.service.rest;

import rd.arvind.service.HelloWorld;

public class HelloRestServiceImpl implements HelloRestService{

    private HelloWorld helloWorld;
    public String handleGet(String name){
        return helloWorld.sayHello();
    }
    public HelloRestServiceImpl(){
    }
	public HelloWorld getHelloWorld() {
		return helloWorld;
	}
	public void setHelloWorld(HelloWorld helloWorld) {
		this.helloWorld = helloWorld;
	}

}