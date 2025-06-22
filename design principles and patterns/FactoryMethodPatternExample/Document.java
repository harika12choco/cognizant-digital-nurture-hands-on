package FactoryMethodPatternExample;
public interface Document
{
    void open();
}
class WordDocument implements Document
{
    public void open()
    {
        System.out.println("opening worddocument");
    }
}
class PdfDocument implements Document
{
    public void open()
    {
        System.out.println("opening pdfdocument");
    }
    
}
class ExcelDocument implements Document
{
     public void open()
    {
        System.out.println("opening excel document");
    }
    
}
abstract class DocumentFactory {
    abstract Document createDocument();
}
class WordDocumentFactory extends DocumentFactory
{
      Document createDocument()
    {
        return new WordDocument();
    }
}
class PdfDocumentFactory  extends DocumentFactory
{
     Document createDocument()
    {
        return new PdfDocument();
    }
}
class ExcelDocumentFactory  extends DocumentFactory
{
    Document createDocument()
    {
        return new ExcelDocument();
    }
}

class Test {
    public static void main(String[] args) {
        DocumentFactory fact1 = new WordDocumentFactory();
        Document doc1 = fact1.createDocument();
        doc1.open();
        DocumentFactory fact2 = new PdfDocumentFactory();
        Document doc2 = fact2.createDocument();
        doc2.open();
        DocumentFactory fact3 = new ExcelDocumentFactory();
        Document doc3 = fact3.createDocument();
        doc3.open();
    }
}