import javax.jws.WebService
import javax.jws.soap.SOAPBinding
import javax.jws.soap.SOAPBinding.Style
import javax.xml.ws.Endpoint

@WebService(targetNamespace="org.scalabound.test", name="org.scalabound.test", portName="test", serviceName="WSTest")
private class MinimalSoapServer {

    @SOAPBinding(style = Style.RPC)
    def test(value : String) = "Hi " + value

}
object MinimalSoapServer {                                          // defined Companion Object for our class

    def main(args: Array[String]) {                                   // main method to make this a runnable application
        val endpoint = Endpoint.publish("http://localhost:8080/wstest", new MinimalSoapServer())
        System.out.println("Waiting for requests...")
    }
}