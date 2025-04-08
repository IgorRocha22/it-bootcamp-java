package com.bootcamp.meli.codigo_morse.constantes;

public enum CodigoMorseEnum {
	A(".-"), //
	B("-..."), //
	C("-.-."), //
	D("-.."), //
	E("."), //
	F("..-."), //
	G("--."), //
	H("...."), //
	I(".."), //
	J(".---"), //
	K("-.-"), //
	L(".-.."), //
	M("--"), //
	N("-."), //
	O("---"), //
	P(".--."), //
	Q("--.-"), //
	R(".-."), //
	S("..."), //
	T("-"), //
	U("..-"), //
	V("...-"), //
	W(".--"), //
	X("-..-"), //
	Y("-.--"), //
	Z("--.."), //
	UM(".----"), //
	DOIS("..---"), //
	TRES("...--"), //
	QUATRO("....-"), //
	CINCO("....."), //
	SEIS("-...."), //
	SETE("--..."), //
	OITO("---.."), //
	NOVE("----."), //
	ZERO("-----"), //
	INTERROGACAO("..--.."), //
	EXCLAMACAO("-.-.--"), //
	PONTO(".-.-.-"), //
	VIRGULA("--..--");

	private String valor;

	CodigoMorseEnum(String valor) {
		this.valor = valor;
	}

	public String getValor() {
		return valor;
	}

	public void setValor(String valor) {
		this.valor = valor;
	}
}
