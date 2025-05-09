package org.example.Vista;

import org.example.Controlador.VistaController;
import org.example.Modelo.Equipo;
import org.example.Modelo.Jugador;

import javax.swing.*;
import java.sql.SQLException;
import java.util.List;

public class DVisualizarEquipos extends JDialog {
    private JPanel pPrincipal;
    private JPanel pHeader;
    private JPanel pBody;
    private JTextArea taMostrar;
    private JButton bVolver;
    private JButton buttonOK;
    private VistaController vistaController;
    public DVisualizarEquipos(VistaController vistaController) throws SQLException {
        this.vistaController = vistaController;

        setContentPane(pPrincipal);
        setModal(true);
        setSize(500, 350);
        setLocationRelativeTo(null);
        getRootPane().setDefaultButton(buttonOK);


        List<Equipo> equipos = vistaController.mostrar();
        /**
         * Recorremos la lista de equipos y mostramos los jugadores de cada equipo y sus nicknames
         */
        for ( int i = 0; i < equipos.size(); i++ ) {
            taMostrar.append(equipos.get(i).getNombreEquipo());

            taMostrar.append("\n");
            List <Jugador> jugadors = vistaController.mostrarJugadores(equipos.get(i).getCodEquipo());
            for (int j = i + 1; j < equipos.size(); j++ ) {
                taMostrar.append(jugadors.get(j).getNombre());
                taMostrar.append(" Alias: ");
                taMostrar.append(jugadors.get(j).getNickname());
                taMostrar.append("\n");
                taMostrar.append(jugadors.get(j).getRol().toString());
                taMostrar.append("\n");
            }
            taMostrar.append("\n \n \n");
            taMostrar.append("---------------------------------");
            taMostrar.append("\n");

        }


    }
}
