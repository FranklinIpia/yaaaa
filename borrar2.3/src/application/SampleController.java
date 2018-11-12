package application;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import javafx.beans.property.Property;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import modelo.Persona;

public class SampleController implements Initializable {
	@FXML
	private TableView<Persona> tableViewPersonas;
	
	@FXML
	private TableColumn<Persona,String> tableColimnaNombre;
	
	@FXML
	private TableColumn<Persona,Integer> tableColimnaedad;
	
	private List <Persona> listaPersona= new ArrayList();
	
	private ObservableList<Persona> observableListPersona;
	
	@FXML
	private Button aniadir;

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		try {
			cargarTablePersonas();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		
	}
	
	public void cargarTablePersonas() throws FileNotFoundException, IOException {
		tableColimnaNombre.setCellValueFactory(new PropertyValueFactory<>("nombre"));
		tableColimnaedad.setCellValueFactory(new PropertyValueFactory<>("Edad"));
		
		
		//Persona p1=new Persona("franklin","23");
		//Persona p2=new Persona();
		
		listaPersona.add(new Persona("franklin",23));
		listaPersona.add(new Persona("franklin1",24));
		handleNewPerson();
		guardar(listaPersona);
		
		observableListPersona=FXCollections.observableArrayList( listaPersona);
		
		tableViewPersonas.setItems(observableListPersona);
	}
	
	 public static void guardar(Object Jugador) throws FileNotFoundException, IOException{
			ObjectOutputStream salida = new ObjectOutputStream(new FileOutputStream("jugador.obj"));
			
			
			 if(salida != null ){
	            salida.writeObject(Jugador);
	             salida.close();
	           System.out.println("yes");
	         }
			
		}
		public Object recuperar () throws IOException, ClassNotFoundException{
			
			Object jugador;
			ObjectInputStream entrada= new ObjectInputStream(new FileInputStream("jugador.obj"));
			
			jugador= (Object) entrada.readObject();
			
				entrada.close();
				
				return jugador;
				}
		@FXML
		 private void handleNewPerson() {
		        Persona tempPerson = new Persona("ipia",458);
		    
		        
		            listaPersona.add(tempPerson);
		        System.out.println("si");
		    }
	
}
