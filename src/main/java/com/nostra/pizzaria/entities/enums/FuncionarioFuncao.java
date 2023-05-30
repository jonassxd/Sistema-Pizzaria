package com.nostra.pizzaria.entities.enums;

public enum FuncionarioFuncao {
	GERENTE(1),
	PIZZAIOLO(2),
	MOTOBOY(3),
	LIMPEZA(4);
	
	
		
	
	private int codigo;
	
	private FuncionarioFuncao(int codigo) {
		this.codigo = codigo;
	}

	public int getCodigo() {
		return codigo;
	}

	public static FuncionarioFuncao valueOf( int codigo) {
		for(FuncionarioFuncao value: FuncionarioFuncao.values()) {
			if(value.getCodigo() == codigo) {
				return value;
			}
		}
		throw new IllegalArgumentException("Código de Funcionário inválido");
	}
}