
import com.davivienda.generarReporte.exception.GenerarReporteException;
import com.davivienda.generarReporte.util.N2T;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.ArrayList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author frengifo
 */
public class test {
    ArrayList array2=new ArrayList();
    //38.000.000.00
    //3.800.000.000.00
    static public void main(String args[]) throws Exception
    {
       test t=new test();
       
     //  System.out.println(t.numeroALetra("38000000.10   ", true, true));
      System.out.println(t.formatearNumero("3800000010",8,2, "N/A",true,false)+"-");
    /*   System.out.println(t.formatearNumerov2("3800000000",8,2, "N/A",false,false));
        System.out.println(t.formatearNumerov2("3800000000",8,7, "N/A",false,false));
        System.out.println(t.formatearNumerov2("3800000000",8,7, "N/A",true,false));
        System.out.println(t.formatearNumerov2("3800000000",1,1, "N/A",true,false));
         System.out.println(t.formatearNumerov2("3800000000",11,1, "N/A",true,false));
         System.out.println(t.formatearNumerov2("3800000000",1,12, "N/A",true,false));*/
    }
    
    //
     public String formatearNumero(String palabra, int enteros, int decimales, String signoMoneda, boolean separadorMiles, boolean posicionSignoMoneda) throws Exception {
        try {
            String formato = "";
            if (decimales > 0) {
                for (int i = 0; i < decimales; i++) {
                    formato = formato.concat("0");
                }
                formato = formato.concat(".");
            }

            if (enteros > 0) {
                for (int i = 1; i <= enteros; i++) {
                    if (i == 1) {
                        formato = formato.concat("0");
                    } else {
                        formato = formato.concat("#");
                    }
                    if (i > 1 && i % 3 == 0 && separadorMiles) {
                        formato = formato.concat(",");
                    }
                }
            } else {
                if (separadorMiles) {
                    formato = formato.concat("0##,###,###,###,###,###");
                } else {
                    formato = formato.concat("0#################");
                }
            }

            StringBuilder str = new StringBuilder(formato);
            formato = str.reverse().toString();
System.out.println(formato);
            if (!signoMoneda.equals("N/A")) {
                if (posicionSignoMoneda) {
                    formato = signoMoneda.concat(formato);
                } else {
                    formato = formato.concat(signoMoneda);
                }
            }

            DecimalFormatSymbols otherSymbols = new DecimalFormatSymbols();
            otherSymbols.setDecimalSeparator('.');
            otherSymbols.setGroupingSeparator(',');
            DecimalFormat myFormatter = new DecimalFormat(formato, otherSymbols);
            String numero = myFormatter.format(Double.parseDouble(palabra));
            return numero;
        } catch (NumberFormatException e) {
               throw new Exception("No fue posible formatear el Numero: " + palabra + " - " + e.getMessage());
        }
    }
     
     
       public static String formatearNumerov2(String palabra, int enteros, int decimales, String signoMoneda, boolean separadorMiles, boolean posicionSignoMoneda) throws GenerarReporteException {
        try {
            String formato = "";
            if (decimales > 0) {
                for (int i = 0; i < decimales; i++) {
                    formato = formato.concat("0");
                }
                formato = formato.concat(".");
            }

            if (decimales > 0) {
                int l = palabra.length();
                int nroEnterosReales = l - decimales;
                if (nroEnterosReales > 0) {
                    palabra = palabra.substring(0, nroEnterosReales).concat(".").concat(palabra.substring(nroEnterosReales));
                } else {
                    palabra = "0." + palabra;
                }
            }

            if (enteros > 0) {
                for (int i = 1; i <= enteros; i++) {
                    if (i == 1) {
                        formato = formato.concat("0");
                    } else {
                        formato = formato.concat("#");
                    }
                    if (i > 1 && i % 3 == 0 && separadorMiles) {
                        formato = formato.concat(",");
                    }
                }
            } else {
                if (separadorMiles) {
                    formato = formato.concat("0##,###,###,###,###,###");
                } else {
                    formato = formato.concat("0#################");
                }
            }

            StringBuilder str = new StringBuilder(formato);
            formato = str.reverse().toString();

            if (!signoMoneda.equals("N/A")) {
                if (posicionSignoMoneda) {
                    formato = signoMoneda.concat(formato);
                } else {
                    formato = formato.concat(signoMoneda);
                }
            }

            DecimalFormatSymbols otherSymbols = new DecimalFormatSymbols();
            otherSymbols.setDecimalSeparator('.');
            otherSymbols.setGroupingSeparator(',');
            DecimalFormat myFormatter = new DecimalFormat(formato, otherSymbols);
            String numero = myFormatter.format(Double.parseDouble(palabra));
            return numero;
        } catch (NumberFormatException e) {
            throw new GenerarReporteException("718", "No fue posible formatear el Numero: " + palabra + " - " + e.getMessage());
        }
    }
       
       
       private String numeroALetra(String palabra, boolean flagFemenino, boolean flagPorcentaje) throws GenerarReporteException {
        try {
            N2T parteEntera;
            if (palabra.contains(".")) {
                String[] numeros = palabra.replace(".", ",").split(",");
                N2T parteDecimal;
                parteEntera = new N2T(Long.valueOf(numeros[0]), flagFemenino, numeros[0], flagPorcentaje);
                if (numeros[1] != null) {
                    parteDecimal = new N2T(Long.valueOf(numeros[1]), flagFemenino, numeros[1], flagPorcentaje);
                    //if (parteDecimal.numero>0)
                    if (flagPorcentaje) {
                        return parteEntera.convertirLetras().concat(" punto ").concat(parteDecimal.convertirLetras());
                    } else {
                        return parteEntera.convertirLetras().concat(" con ").concat(parteDecimal.convertirLetras()).concat(parteDecimal.unidadDecimal());
                    }
                    //else
                    //  return parteEntera.convertirLetras();
                } else {
                    return parteEntera.convertirLetras();
                }
            } else {
                parteEntera = new N2T(Long.valueOf(palabra), flagFemenino, palabra, flagPorcentaje);
                return parteEntera.convertirLetras();
            }
        } catch (NumberFormatException e) {
            throw new GenerarReporteException("719", "No fue posible transformar numero a letra: " + palabra + " - " + e.getMessage());
        }
    }
}

   


