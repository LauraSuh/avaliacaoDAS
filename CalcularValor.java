
public class CalcularValor {
	private Acesso acesso;
	private int quantidadeHoras;
	private int quantidadeMinutos;
	private double valorHoras;
	private double valorMinutos;
	private float valorTotal;

	public CalcularValor(Acesso source) {
		this.acesso = source;
	}
	
	public float calcularValor() { 
		this.quantidadeHoras = acesso.horaSaida - acesso.horaEntrada; 
		this.quantidadeMinutos = acesso.minutosSaida - acesso.minutosEntrada; 

		//Simplificação de expressões condicionais realizada. Muitas expressões redundantes.
		if (acesso.horaSaida > acesso.horaEntrada && acesso.minutosSaida < acesso.minutosEntrada){
			this.quantidadeMinutos = acesso.minutosSaida + (60 - acesso.minutosEntrada);
			this.quantidadeHoras = acesso.horaSaida - acesso.horaEntrada - 1;
		}
				
		this.valorHoras = this.quantidadeHoras * acesso.VALOR_HORA;
		this.valorMinutos = Math.ceil(this.quantidadeMinutos / 15.0) * acesso.VALOR_FRACAO;
		this.valorTotal = (float) (valorHoras + valorMinutos);
		
		if (this.quantidadeHoras >=9)
			return acesso.VALOR_DIARIA;
		else 
			return this.valorTotal;
	}
	
}