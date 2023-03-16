package com.davivienda.generarReporte.util;

public class N2T {

    private int flag;
    private boolean flagFemenino;
    private boolean flagPorcentaje;
    public long numero;
    public long numeroOrig;
    public String numeroAux;
    public String importe_parcial;
    public String num;
    public String num_letra;
    public String num_letras;
    public String num_letram;
    public String num_letradm;
    public String num_letracm;
    public String num_letramm;
    public String num_letradmm;

    public N2T() {
        super();
        this.numero = 0L;
        this.flag = 0;
        this.flagFemenino = false;
        this.flagPorcentaje = false;
    }

    public N2T(final long n, final boolean f, final String nAux, final boolean p) {
        super();
        this.numero = n;
        this.numeroOrig = n;
        this.flag = 0;
        this.flagFemenino = f;
        this.numeroAux = nAux;
        this.flagPorcentaje = p;
    }

    private String unidad(final long numero) {
        switch ((int) numero) {
            case 9: {
                this.num = "nueve";
                break;
            }
            case 8: {
                this.num = "ocho";
                break;
            }
            case 7: {
                this.num = "siete";
                break;
            }
            case 6: {
                this.num = "seis";
                break;
            }
            case 5: {
                this.num = "cinco";
                break;
            }
            case 4: {
                this.num = "cuatro";
                break;
            }
            case 3: {
                this.num = "tres";
                break;
            }
            case 2: {
                this.num = "dos";
                break;
            }
            case 1: {
                if (this.flag == 0) {
                    this.num = "uno";
                    break;
                }
                this.num = "un";
                break;
            }
            case 0: {
                if (this.numeroOrig == 0L) {
                    this.num = "cero";
                    break;
                }
                this.num = "";
                break;
            }
        }
        return this.num;
    }

    private String decena(final long numero) {
        if (numero >= 90L && numero <= 99L) {
            this.num_letra = "noventa ";
            if (numero > 90L) {
                this.num_letra = this.num_letra.concat("y ").concat(this.unidad(numero - 90L));
            }
        } else if (numero >= 80L && numero <= 89L) {
            this.num_letra = "ochenta ";
            if (numero > 80L) {
                this.num_letra = this.num_letra.concat("y ").concat(this.unidad(numero - 80L));
            }
        } else if (numero >= 70L && numero <= 79L) {
            this.num_letra = "setenta ";
            if (numero > 70L) {
                this.num_letra = this.num_letra.concat("y ").concat(this.unidad(numero - 70L));
            }
        } else if (numero >= 60L && numero <= 69L) {
            this.num_letra = "sesenta ";
            if (numero > 60L) {
                this.num_letra = this.num_letra.concat("y ").concat(this.unidad(numero - 60L));
            }
        } else if (numero >= 50L && numero <= 59L) {
            this.num_letra = "cincuenta ";
            if (numero > 50L) {
                this.num_letra = this.num_letra.concat("y ").concat(this.unidad(numero - 50L));
            }
        } else if (numero >= 40L && numero <= 49L) {
            this.num_letra = "cuarenta ";
            if (numero > 40L) {
                this.num_letra = this.num_letra.concat("y ").concat(this.unidad(numero - 40L));
            }
        } else if (numero >= 30L && numero <= 39L) {
            this.num_letra = "treinta ";
            if (numero > 30L) {
                this.num_letra = this.num_letra.concat("y ").concat(this.unidad(numero - 30L));
            }
        } else if (numero >= 20L && numero <= 29L) {
            if (numero == 20L) {
                this.num_letra = "veinte ";
            } else {
                this.num_letra = "veinti".concat(this.unidad(numero - 20L));
            }
        } else if (numero >= 10L && numero <= 19L) {
            switch ((int) numero) {
                case 10: {
                    this.num_letra = "diez ";
                    break;
                }
                case 11: {
                    this.num_letra = "once ";
                    break;
                }
                case 12: {
                    this.num_letra = "doce ";
                    break;
                }
                case 13: {
                    this.num_letra = "trece ";
                    break;
                }
                case 14: {
                    this.num_letra = "catorce ";
                    break;
                }
                case 15: {
                    this.num_letra = "quince ";
                    break;
                }
                case 16: {
                    this.num_letra = "dieciseis ";
                    break;
                }
                case 17: {
                    this.num_letra = "diecisiete ";
                    break;
                }
                case 18: {
                    this.num_letra = "dieciocho ";
                    break;
                }
                case 19: {
                    this.num_letra = "diecinueve ";
                    break;
                }
            }
        } else {
            this.num_letra = this.unidad(numero);
        }
        return this.num_letra;
    }

    private String centena(final long numero) {
        if (numero >= 100L) {
            if (numero >= 900L && numero <= 999L) {
                this.num_letra = "novecientos ";
                if (numero > 900L) {
                    this.num_letra = this.num_letra.concat(this.decena(numero - 900L));
                }
            } else if (numero >= 800L && numero <= 899L) {
                this.num_letra = "ochocientos ";
                if (numero > 800L) {
                    this.num_letra = this.num_letra.concat(this.decena(numero - 800L));
                }
            } else if (numero >= 700L && numero <= 799L) {
                this.num_letra = "setecientos ";
                if (numero > 700L) {
                    this.num_letra = this.num_letra.concat(this.decena(numero - 700L));
                }
            } else if (numero >= 600L && numero <= 699L) {
                this.num_letra = "seiscientos ";
                if (numero > 600L) {
                    this.num_letra = this.num_letra.concat(this.decena(numero - 600L));
                }
            } else if (numero >= 500L && numero <= 599L) {
                this.num_letra = "quinientos ";
                if (numero > 500L) {
                    this.num_letra = this.num_letra.concat(this.decena(numero - 500L));
                }
            } else if (numero >= 400L && numero <= 499L) {
                this.num_letra = "cuatrocientos ";
                if (numero > 400L) {
                    this.num_letra = this.num_letra.concat(this.decena(numero - 400L));
                }
            } else if (numero >= 300L && numero <= 399L) {
                this.num_letra = "trescientos ";
                if (numero > 300L) {
                    this.num_letra = this.num_letra.concat(this.decena(numero - 300L));
                }
            } else if (numero >= 200L && numero <= 299L) {
                this.num_letra = "doscientos ";
                if (numero > 200L) {
                    this.num_letra = this.num_letra.concat(this.decena(numero - 200L));
                }
            } else if (numero >= 100L && numero <= 199L) {
                if (numero == 100L) {
                    this.num_letra = "cien ";
                } else {
                    this.num_letra = "ciento ".concat(this.decena(numero - 100L));
                }
            }
        } else {
            this.num_letra = this.decena(numero);
        }
        return this.num_letra;
    }

    private String miles(final long numero) {
        if (numero >= 1000L && numero < 2000L) {
            this.num_letram = "mil ".concat(this.centena(numero % 1000L));
        }
        if (numero >= 2000L && numero < 10000L) {
            this.flag = 1;
            this.num_letram = this.unidad(numero / 1000L).concat(" mil ").concat(this.centena(numero % 1000L));
        }
        if (numero < 1000L) {
            this.num_letram = this.centena(numero);
        }
        return this.num_letram;
    }

    private String decmiles(final long numero) {
        if (numero == 10000L) {
            this.num_letradm = "diez mil";
        }
        if (numero > 10000L && numero < 20000L) {
            this.flag = 1;
            this.num_letradm = this.decena(numero / 1000L).concat("mil ").concat(this.centena(numero % 1000L));
        }
        if (numero >= 20000L && numero < 100000L) {
            this.flag = 1;
            this.num_letradm = this.decena(numero / 1000L).concat(" mil ").concat(this.miles(numero % 1000L));
        }
        if (numero < 10000L) {
            this.num_letradm = this.miles(numero);
        }
        return this.num_letradm;
    }

    private String cienmiles(final long numero) {
        if (numero == 100000L) {
            this.num_letracm = "cien mil";
        }
        if (numero >= 100000L && numero < 1000000L) {
            this.flag = 1;
            this.num_letracm = this.centena(numero / 1000L).concat(" mil ").concat(this.centena(numero % 1000L));
        }
        if (numero < 100000L) {
            this.num_letracm = this.decmiles(numero);
        }
        return this.num_letracm;
    }

    private String millon(final long numero) {
        if (numero >= 1000000L && numero < 2000000L) {
            this.flag = 1;
            this.num_letramm = "Un millon ".concat(this.cienmiles(numero % 1000000L));
        }
        if (numero >= 2000000L && numero < 10000000L) {
            this.flag = 1;
            this.num_letramm = this.unidad(numero / 1000000L).concat(" millones ").concat(this.cienmiles(numero % 1000000L));
        }
        if (numero < 1000000L) {
            this.num_letramm = this.cienmiles(numero);
        }
        return this.num_letramm;
    }

    private String decmillon(final long numero) {
        if (numero == 10000000L) {
            this.num_letradmm = "diez millones";
        }
        if (numero > 10000000L && numero < 20000000L) {
            this.flag = 1;
            this.num_letradmm = this.decena(numero / 1000000L).concat("millones ").concat(this.cienmiles(numero % 1000000L));
        }
        if (numero >= 20000000L && numero < 100000000L) {
            this.flag = 1;
            this.num_letradmm = this.decena(numero / 1000000L).concat(" milllones ").concat(this.millon(numero % 1000000L));
        }
        if (numero < 10000000L) {
            this.num_letradmm = this.millon(numero);
        }
        return this.num_letradmm;
    }

    private String cienmillon(final long numero) {
        if (numero == 100000000L) {
            this.num_letracm = "cien millones";
        }
        if (numero >= 100000000L && numero < 1000000000L) {
            this.flag = 1;
            this.num_letracm = this.centena(numero / 1000000L).concat(" millones ").concat(this.cienmiles(numero % 1000000L));
        }
        if (numero < 100000000L) {
            this.num_letracm = this.decmillon(numero);
        }
        return this.num_letracm;
    }

    private String milmillones(final long numero) {
        if (numero == 1000000000L) {
            this.num_letracm = "mil millones";
        }
        if (numero >= 1000000000L && numero < 2000000000L) {
            this.num_letram = "mil ".concat(this.cienmillon(numero % 1000000000L));
        }
        if (numero >= 2000000000L && numero < Long.valueOf("10000000000")) {
            this.flag = 1;
            this.num_letram = this.unidad(numero / 1000000000L).concat(" mil ").concat(this.cienmillon(numero % 1000000000L));
        }
        if (numero < 1000000000L) {
            this.num_letram = this.cienmillon(numero);
        }
        return this.num_letram;
    }

    public String convertirLetras() {
        this.num_letras = this.milmillones(this.numero);
        if (this.flagFemenino) {
            this.num_letras = this.num_letras.replaceAll("cientos ", "cientas ");
            if (this.num_letras.substring(this.num_letras.length() - 2).equals("un")) {
                this.num_letras = this.num_letras.concat("a");
            }
        }
        return this.num_letras;
    }

    public String unidadDecimal() {
        if (this.numeroAux.length() == 1) {
            return this.flagFemenino ? " décimas" : " décimos";
        }
        if (this.numeroAux.length() == 2) {
            return this.flagFemenino ? " centésimas" : " centésimos";
        }
        if (this.numeroAux.length() == 3) {
            return this.flagFemenino ? " milésimas" : " milésimos";
        }
        return this.flagFemenino ? " diezmilésimas" : " diezmilésimos";
    }
}
