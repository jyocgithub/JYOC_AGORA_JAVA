package cap50_a_12_MundialBaloncesto.clases;

public class JugarMundial {
	public static void main(String[] args) {


		Mundial mundial = new Mundial();
		mundial.crearEquipos();
		mundial.convocar();
		mundial.listarConvocados();
		
		mundial.clasificacion();
		mundial.clasificar();
		mundial.pintarClasificadosGrupo();
		
		mundial.fasefinal();
		
		
	}
	
}
