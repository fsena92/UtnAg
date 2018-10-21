package ar.edu.utn.frba.ia.ag.paro;

import java.util.List;

import ar.edu.utn.frba.ia.ag.Individuo;

public class AptitudMinimaPromedio extends CriterioDeParo {

	static final int MAX_APT_PROM = 49;//Algunas corridas tiraron 48.6
	private double minValEstadistica = Double.MAX_VALUE;
	private Integer corteIteracion;
	
	public AptitudMinimaPromedio(double valEstadistica, Integer corteIteracion) {
		this.minValEstadistica = MAX_APT_PROM * valEstadistica;
		//En caso de no llegar a la combinación esperada
		this.corteIteracion = corteIteracion;
	}
	
	@Override
	public Boolean parar(List<Individuo> individuos) {
		
		if (this.corteIteracion > 0) {
			double totalAptitud = 0;
			double promAptitud = 0;
			
			for (Individuo individuo : individuos) {
				totalAptitud += individuo.aptitud();
			}
			
			promAptitud = totalAptitud / individuos.size();
			
			this.corteIteracion--;
			return (promAptitud >= minValEstadistica);
			//return (promEstadisticas >= minValEstadistica && promCaracteristicas >= minValCaracteristica);
		}
		
		return true;
	}
	
}
