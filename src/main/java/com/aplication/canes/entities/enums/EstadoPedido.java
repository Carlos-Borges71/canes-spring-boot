package com.aplication.canes.entities.enums;

public enum EstadoPedido {

    AGUARDANDO_PAGAMENTO(1),
    PAGO(2),
    CANCELADO(3);
    private int code;

    private EstadoPedido(Integer code){
        this.code = code;
    }

    public Integer getCode() {
		return code;
	}

    public static EstadoPedido fromCodigo(Integer code){
    for (EstadoPedido status : values()){
      if (status.code == code){
        return status;
      }
    }
    throw new IllegalArgumentException("Invalid EstadoPedido code: "+ code); 
  }
}
