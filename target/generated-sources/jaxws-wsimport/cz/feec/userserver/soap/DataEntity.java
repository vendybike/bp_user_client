
package cz.feec.userserver.soap;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for dataEntity complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="dataEntity">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="fat" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *         &lt;element name="id" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="pulse" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *         &lt;element name="stress" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *         &lt;element name="weight" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "dataEntity", propOrder = {
    "fat",
    "id",
    "pulse",
    "stress",
    "weight"
})
public class DataEntity {

    protected double fat;
    protected Long id;
    protected double pulse;
    protected double stress;
    protected double weight;

    /**
     * Gets the value of the fat property.
     * 
     */
    public double getFat() {
        return fat;
    }

    /**
     * Sets the value of the fat property.
     * 
     */
    public void setFat(double value) {
        this.fat = value;
    }

    /**
     * Gets the value of the id property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getId() {
        return id;
    }

    /**
     * Sets the value of the id property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setId(Long value) {
        this.id = value;
    }

    /**
     * Gets the value of the pulse property.
     * 
     */
    public double getPulse() {
        return pulse;
    }

    /**
     * Sets the value of the pulse property.
     * 
     */
    public void setPulse(double value) {
        this.pulse = value;
    }

    /**
     * Gets the value of the stress property.
     * 
     */
    public double getStress() {
        return stress;
    }

    /**
     * Sets the value of the stress property.
     * 
     */
    public void setStress(double value) {
        this.stress = value;
    }

    /**
     * Gets the value of the weight property.
     * 
     */
    public double getWeight() {
        return weight;
    }

    /**
     * Sets the value of the weight property.
     * 
     */
    public void setWeight(double value) {
        this.weight = value;
    }

}
