
package default_package;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the default_package package. 
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

    private final static QName _Cancelar_QNAME = new QName("http://default_package/", "cancelar");
    private final static QName _CancelarResponse_QNAME = new QName("http://default_package/", "cancelarResponse");
    private final static QName _ListarMesas_QNAME = new QName("http://default_package/", "listar_mesas");
    private final static QName _ListarMesasResponse_QNAME = new QName("http://default_package/", "listar_mesasResponse");
    private final static QName _Reservar_QNAME = new QName("http://default_package/", "reservar");
    private final static QName _ReservarResponse_QNAME = new QName("http://default_package/", "reservarResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: default_package
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link Cancelar }
     * 
     */
    public Cancelar createCancelar() {
        return new Cancelar();
    }

    /**
     * Create an instance of {@link CancelarResponse }
     * 
     */
    public CancelarResponse createCancelarResponse() {
        return new CancelarResponse();
    }

    /**
     * Create an instance of {@link ListarMesas }
     * 
     */
    public ListarMesas createListarMesas() {
        return new ListarMesas();
    }

    /**
     * Create an instance of {@link ListarMesasResponse }
     * 
     */
    public ListarMesasResponse createListarMesasResponse() {
        return new ListarMesasResponse();
    }

    /**
     * Create an instance of {@link Reservar }
     * 
     */
    public Reservar createReservar() {
        return new Reservar();
    }

    /**
     * Create an instance of {@link ReservarResponse }
     * 
     */
    public ReservarResponse createReservarResponse() {
        return new ReservarResponse();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Cancelar }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link Cancelar }{@code >}
     */
    @XmlElementDecl(namespace = "http://default_package/", name = "cancelar")
    public JAXBElement<Cancelar> createCancelar(Cancelar value) {
        return new JAXBElement<Cancelar>(_Cancelar_QNAME, Cancelar.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CancelarResponse }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link CancelarResponse }{@code >}
     */
    @XmlElementDecl(namespace = "http://default_package/", name = "cancelarResponse")
    public JAXBElement<CancelarResponse> createCancelarResponse(CancelarResponse value) {
        return new JAXBElement<CancelarResponse>(_CancelarResponse_QNAME, CancelarResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ListarMesas }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link ListarMesas }{@code >}
     */
    @XmlElementDecl(namespace = "http://default_package/", name = "listar_mesas")
    public JAXBElement<ListarMesas> createListarMesas(ListarMesas value) {
        return new JAXBElement<ListarMesas>(_ListarMesas_QNAME, ListarMesas.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ListarMesasResponse }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link ListarMesasResponse }{@code >}
     */
    @XmlElementDecl(namespace = "http://default_package/", name = "listar_mesasResponse")
    public JAXBElement<ListarMesasResponse> createListarMesasResponse(ListarMesasResponse value) {
        return new JAXBElement<ListarMesasResponse>(_ListarMesasResponse_QNAME, ListarMesasResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Reservar }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link Reservar }{@code >}
     */
    @XmlElementDecl(namespace = "http://default_package/", name = "reservar")
    public JAXBElement<Reservar> createReservar(Reservar value) {
        return new JAXBElement<Reservar>(_Reservar_QNAME, Reservar.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ReservarResponse }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link ReservarResponse }{@code >}
     */
    @XmlElementDecl(namespace = "http://default_package/", name = "reservarResponse")
    public JAXBElement<ReservarResponse> createReservarResponse(ReservarResponse value) {
        return new JAXBElement<ReservarResponse>(_ReservarResponse_QNAME, ReservarResponse.class, null, value);
    }

}
