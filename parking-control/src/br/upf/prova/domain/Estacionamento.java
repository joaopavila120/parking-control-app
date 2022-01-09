/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.upf.prova.domain;

/**
 *
 * @author joao
 */
public class Estacionamento {

    //private final String placa;
    private Integer espera;
    private Integer andarUm;
    private Integer andarDois;

    public Integer getEspera() {
        return espera;
    }

    public Integer getAndarUm() {
        return andarUm;
    }

    public Integer getAndarDois() {
        return andarDois;
    }

    public Integer getAndarTres() {
        return andarTres;
    }
    private Integer andarTres;

    public Estacionamento() {
        this.espera = 0;
        this.andarUm = 0;
        this.andarDois = 0;
        this.andarTres = 0;
    }

    public void entrada() throws Exception {
        if (andarUm < 5) {
            ++andarUm;
        } else if (andarDois < 5) {
            ++andarDois;
        } else if (andarTres < 3) {
            ++andarTres;
        } else if (espera < 2) {
            ++espera;
        } else {
            throw new Exception("Inclusive a espera, todas as vagas estão ocupadas!");
        }
    }

    public void saida(Integer andar) throws Exception {
        if (andar == null) {
            throw new Exception("Deve ser informado um andar!");
        }

        switch (andar) {
            case 1:
                if (andarUm > 0) {
                    if (espera > 0) {
                        --espera;
                    } else {
                        --andarUm;
                    }
                }
                else
                {
                     throw new Exception("Andar vazio");
                }
                break;
            case 2:
                if (andarDois > 0) {
                    if (espera > 0) {
                        --espera;
                    } else {
                        --andarDois;
                    }
                }
                 else
                {
                     throw new Exception("Andar vazio");
                }
                break;
            case 3:
                if (andarTres > 0) {
                    if (espera > 0) {
                        --espera;
                    } else {
                        --andarTres;
                    }
                }
                break;
        }
    }

    public Integer getVagasDisponiveis() {

        return 15 - andarUm - andarDois - andarTres - espera;

    }

    public Integer[] getVagasOcupadas() {
        Integer[] vagasOcupadas = new Integer[1];
        vagasOcupadas[0] = 15 - getVagasDisponiveis();

        return vagasOcupadas;

    }
}
