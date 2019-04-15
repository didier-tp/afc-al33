
package fr.afcepf.al33.conv;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the fr.afcepf.al33.conv package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _FrancToEuro_QNAME = new QName("http://conv.al33.afcepf.fr/", "francToEuro");
    private final static QName _EuroToFrancResponse_QNAME = new QName("http://conv.al33.afcepf.fr/", "euroToFrancResponse");
    private final static QName _GetAuteurResponse_QNAME = new QName("http://conv.al33.afcepf.fr/", "getAuteurResponse");
    private final static QName _ConvertirResponse_QNAME = new QName("http://conv.al33.afcepf.fr/", "convertirResponse");
    private final static QName _Convertir_QNAME = new QName("http://conv.al33.afcepf.fr/", "convertir");
    private final static QName _EuroToFranc_QNAME = new QName("http://conv.al33.afcepf.fr/", "euroToFranc");
    private final static QName _FrancToEuroResponse_QNAME = new QName("http://conv.al33.afcepf.fr/", "francToEuroResponse");
    private final static QName _GetAuteur_QNAME = new QName("http://conv.al33.afcepf.fr/", "getAuteur");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: fr.afcepf.al33.conv
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link GetAuteurResponse }
     * 
     */
    public GetAuteurResponse createGetAuteurResponse() {
        return new GetAuteurResponse();
    }

    /**
     * Create an instance of {@link FrancToEuro }
     * 
     */
    public FrancToEuro createFrancToEuro() {
        return new FrancToEuro();
    }

    /**
     * Create an instance of {@link EuroToFrancResponse }
     * 
     */
    public EuroToFrancResponse createEuroToFrancResponse() {
        return new EuroToFrancResponse();
    }

    /**
     * Create an instance of {@link ConvertirResponse }
     * 
     */
    public ConvertirResponse createConvertirResponse() {
        return new ConvertirResponse();
    }

    /**
     * Create an instance of {@link Convertir }
     * 
     */
    public Convertir createConvertir() {
        return new Convertir();
    }

    /**
     * Create an instance of {@link GetAuteur }
     * 
     */
    public GetAuteur createGetAuteur() {
        return new GetAuteur();
    }

    /**
     * Create an instance of {@link EuroToFranc }
     * 
     */
    public EuroToFranc createEuroToFranc() {
        return new EuroToFranc();
    }

    /**
     * Create an instance of {@link FrancToEuroResponse }
     * 
     */
    public FrancToEuroResponse createFrancToEuroResponse() {
        return new FrancToEuroResponse();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link FrancToEuro }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://conv.al33.afcepf.fr/", name = "francToEuro")
    public JAXBElement<FrancToEuro> createFrancToEuro(FrancToEuro value) {
        return new JAXBElement<FrancToEuro>(_FrancToEuro_QNAME, FrancToEuro.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link EuroToFrancResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://conv.al33.afcepf.fr/", name = "euroToFrancResponse")
    public JAXBElement<EuroToFrancResponse> createEuroToFrancResponse(EuroToFrancResponse value) {
        return new JAXBElement<EuroToFrancResponse>(_EuroToFrancResponse_QNAME, EuroToFrancResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetAuteurResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://conv.al33.afcepf.fr/", name = "getAuteurResponse")
    public JAXBElement<GetAuteurResponse> createGetAuteurResponse(GetAuteurResponse value) {
        return new JAXBElement<GetAuteurResponse>(_GetAuteurResponse_QNAME, GetAuteurResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ConvertirResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://conv.al33.afcepf.fr/", name = "convertirResponse")
    public JAXBElement<ConvertirResponse> createConvertirResponse(ConvertirResponse value) {
        return new JAXBElement<ConvertirResponse>(_ConvertirResponse_QNAME, ConvertirResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Convertir }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://conv.al33.afcepf.fr/", name = "convertir")
    public JAXBElement<Convertir> createConvertir(Convertir value) {
        return new JAXBElement<Convertir>(_Convertir_QNAME, Convertir.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link EuroToFranc }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://conv.al33.afcepf.fr/", name = "euroToFranc")
    public JAXBElement<EuroToFranc> createEuroToFranc(EuroToFranc value) {
        return new JAXBElement<EuroToFranc>(_EuroToFranc_QNAME, EuroToFranc.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link FrancToEuroResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://conv.al33.afcepf.fr/", name = "francToEuroResponse")
    public JAXBElement<FrancToEuroResponse> createFrancToEuroResponse(FrancToEuroResponse value) {
        return new JAXBElement<FrancToEuroResponse>(_FrancToEuroResponse_QNAME, FrancToEuroResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetAuteur }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://conv.al33.afcepf.fr/", name = "getAuteur")
    public JAXBElement<GetAuteur> createGetAuteur(GetAuteur value) {
        return new JAXBElement<GetAuteur>(_GetAuteur_QNAME, GetAuteur.class, null, value);
    }

}
