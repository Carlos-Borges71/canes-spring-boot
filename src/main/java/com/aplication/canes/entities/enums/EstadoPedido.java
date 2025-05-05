package com.aplication.canes.entities.enums;

public enum EstadoPedido {

    AGUARDANDO_PAGAMENTO(1),
    PAGO(2),
    CANCELADO(3);
    private int code;

    private EstadoPedido(int code){
        this.code = code;
    }

    public int getCode() {
		return code;
	}

    public static EstadoPedido valueOf(int code) {
		for(EstadoPedido value : EstadoPedido.values()) {
			if(value.getCode() == code) {
				return value;
			}
		}
		throw new IllegalArgumentException("Invalid EstadoPedido code");
	}
}
