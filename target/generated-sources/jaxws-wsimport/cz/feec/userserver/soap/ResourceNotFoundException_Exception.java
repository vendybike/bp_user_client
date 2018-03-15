
package cz.feec.userserver.soap;

import javax.xml.ws.WebFault;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.8
 * Generated source version: 2.2
 * 
 */
@WebFault(name = "ResourceNotFoundException", targetNamespace = "http://soap.userServer.feec.cz/")
public class ResourceNotFoundException_Exception
    extends Exception
{

    /**
     * Java type that goes as soapenv:Fault detail element.
     * 
     */
    private ResourceNotFoundException faultInfo;

    /**
     * 
     * @param faultInfo
     * @param message
     */
    public ResourceNotFoundException_Exception(String message, ResourceNotFoundException faultInfo) {
        super(message);
        this.faultInfo = faultInfo;
    }

    /**
     * 
     * @param faultInfo
     * @param cause
     * @param message
     */
    public ResourceNotFoundException_Exception(String message, ResourceNotFoundException faultInfo, Throwable cause) {
        super(message, cause);
        this.faultInfo = faultInfo;
    }

    /**
     * 
     * @return
     *     returns fault bean: cz.feec.userserver.soap.ResourceNotFoundException
     */
    public ResourceNotFoundException getFaultInfo() {
        return faultInfo;
    }

}