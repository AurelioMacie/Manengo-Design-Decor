package ModelBeans;

import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.PlainDocument;

/**
 *
 * @author Junior Macie
 */
public class Controle_De_Digitos extends PlainDocument{
    private int qtd;
        
    public Controle_De_Digitos(int maxLen){
        
        super();
        
        if (maxLen <= 0)
            throw new IllegalArgumentException("Especifique a quantidade");
            qtd=maxLen;
        }

    @Override
    public void insertString(int offs, String str, AttributeSet a) throws BadLocationException {
        
        if (str==null || getLength()==qtd) 
            return;
        int quantidadeTotal = (getLength()+str.length());
        if (quantidadeTotal<=qtd) {
            super.insertString(offs, str.replaceAll("[^a-z|^0-9|^A-Z]",""), a);
            return;
        }
        String nova = str.substring(0, getLength()-qtd);
        super.insertString(offs, nova, a); //To change body of generated methods, choose Tools | Templates.
    }   
}
