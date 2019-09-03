package com.VDP.atividadepa;

import android.os.Parcel;
import android.os.Parcelable;

public class Produto implements Parcelable {

    private String descricao;
    private int quantidade;
    private double valorUni;

    public Produto(String descricao, int quantidade, double valorUni) {
        this.descricao = descricao;
        this.quantidade = quantidade;
        this.valorUni = valorUni;
    }

    protected Produto(Parcel in) {
        descricao = in.readString();
        quantidade = in.readInt();
        valorUni = in.readDouble();
    }

    public static final Creator<Produto> CREATOR = new Creator<Produto>() {
        @Override
        public Produto createFromParcel(Parcel in) {
            return new Produto(in);
        }

        @Override
        public Produto[] newArray(int size) {
            return new Produto[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {

        parcel.writeString(descricao);
        parcel.writeInt(quantidade);
        parcel.writeDouble(valorUni);
    }

    public double getValorUni() {
        return valorUni;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public static double valorTotal(int quant, double valor){
        return quant * valor;
    }

}
