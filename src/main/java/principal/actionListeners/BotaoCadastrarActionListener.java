package principal.actionListeners;

import principal.design.DesignCadastroUsuario;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BotaoCadastrarActionListener implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
        DesignCadastroUsuario.getDesignCadastroUsuario();
    }
}
