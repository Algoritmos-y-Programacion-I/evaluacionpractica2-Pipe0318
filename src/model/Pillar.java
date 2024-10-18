package model;

public class Pillar {

    private String name;
    private Project[] projects;

    public Pillar(String name) {
        this.name = name;
        projects = new Project[50];
    }

    /**
     * Descripcion: Añade un nuevo Project al arreglo projects
     * pre: El arreglo projects debe estar inicializado
     * pos: El arreglo projects queda modificado con el nuevo Project
     * agregado
     * 
     * @param newProject Project El Project que se va a añadir
     * @return boolean true si se logra añadir el Project, false en caso
     *         contrario
     */
    public boolean registerProject(Project newProject) {
        
        for(int l = 0; l < projects.length; l++){
            if (projects[l] == null){
            projects[l]= newProject;
            return true;
            }
        }
        return false;
    }

    /**
     * Descripcion: Genera una cadena en formato lista con la información de los
     * Project registrados en el Pillar
     * pre: El arreglo projects debe estar inicializado
     * 
     */
    public String getProjectList() {

        String list = "";

        boolean validar = false; 
         if (projects == null){
             list = "No hay projectos registrados";
         } else {
        for(int j=0; j<projects.length; j++){
             if(projects[j]!=null){
                 list+=j+1+"."+projects[j].toString()+"\n";
                 validar=true;
             } 
 
             
         }
         if (validar==false){
             list = "No hay projectos registrados";
        
         }
        }
        return list;
    }


}
