package model;

public class Controller {

    private Pillar[] memoria1;
    public Pillar pillars;
    
    public Controller() {
        
        memoria1 = new Pillar[4];
        memoria1[0] = new Pillar ("Biodiversidad");
        memoria1[1] = new Pillar ("Agua");
        memoria1[2] = new Pillar ("Tratamiento de Basuras");
        memoria1[3] = new Pillar ("Energía");

        

    }

    /**
     * Descripcion: Permite crear y añadir un Project en un Pillar en el sistema
     * 
     * @return boolean true si se logra añadir el Prject en el Pillar, false en caso
     *         contrario
     */
    public boolean registerProjectInPillar(int pillarType, String id, String name, String description,boolean status) {
        if (pillars == null) {
            pillars = memoria1[pillarType];
        }
        return pillars.registerProject(new Project(id, name, description,status));
    }

    /**
     * Descripcion: Calcula el valor en dinero correspondiente al arrendamiento
     * mensual de todos los Edificios
     * pre: El arreglo edificios debe estar inicializado
     * 
     * @return String cadena en formato lista con la información de los
     * Project registrados en el Pillar
     */
    public String queryProjectsByPillar(int pillarType) {
        if (pillars == null) {
            pillars = memoria1[pillarType];
        }
        
        return pillars.getProjectList();
    


        

        

    }

}