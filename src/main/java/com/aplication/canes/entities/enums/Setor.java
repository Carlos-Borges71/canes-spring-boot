package com.aplication.canes.entities.enums;

public enum Setor {

    VENDA(1),
    ADMINISTRATIVO(2),
    GERENCIA(3);
    private int code;

    private Setor(int code){
        this.code = code;
    }

    public int getCode() {
		return code;
	}

    public static Setor valueOf(int code) {
		for(Setor value : Setor.values()) {
			if(value.getCode() == code) {
				return value;
			}
		}
		throw new IllegalArgumentException("Invalid Setor code");
	}
}
