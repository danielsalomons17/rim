//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package generated;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;

@XmlRegistry
public class ObjectFactory {
    private static final QName _Lexicon_QNAME = new QName("", "lexicon");

    public ObjectFactory() {
    }

    public LexiconType createLexiconType() {
        return new LexiconType();
    }

    public ArType createArType() {
        return new ArType();
    }

    @XmlElementDecl(
        namespace = "",
        name = "lexicon"
    )
    public JAXBElement<LexiconType> createLexicon(LexiconType value) {
        return new JAXBElement(_Lexicon_QNAME, LexiconType.class, (Class)null, value);
    }
}
