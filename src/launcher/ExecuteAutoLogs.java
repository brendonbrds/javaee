package launcher;

import java.awt.Dimension;
import java.awt.Font;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.plaf.FontUIResource;

public class ExecuteAutoLogs {

	public static void main(String[] args) throws IOException {
		BufferedWriter bw = null;
		try {
			bw = new BufferedWriter(new FileWriter("./AutoJava.log"));
			bw.write("Inicio em " + getDate());

			// INICIO DE CONFIGURACOES DO PC
			UIManager.put("OptionPane.messageFont", new FontUIResource(new Font("Courier New", Font.BOLD, 14)));
			UIManager.put("OptionPane.minimumSize", new Dimension(600, 400));
			JOptionPane.showMessageDialog(null, getMessage(), "INFORMATIVO", JOptionPane.INFORMATION_MESSAGE);
			// FIM DE CONFIGURACOES DO PC

			bw.write(" | Fim em " + getDate());
		} catch (Exception e) {
			UIManager.put("OptionPane.minimumSize", new Dimension(600, 400));
			UIManager.put("OptionPane.messageFont", new FontUIResource(new Font("Courier New", Font.BOLD, 14)));
			JOptionPane.showMessageDialog(null, e.getMessage(), "Algo de errado não está certo!", JOptionPane.ERROR_MESSAGE);
		} finally {
			if (bw != null)
				bw.close();
		}

	}

	public static String getDate() {
		Date datahora = new Date();
		String data = new SimpleDateFormat("dd/MM/yyyy").format(datahora);
		String hora = new SimpleDateFormat("HH:mm:ss").format(datahora);
		return data + " - " + hora;
	}

	public static String getMessage() {
		String message = "SecInfo 2BECmb - Normas gerais - Evitar uso de pendrives \n - Nao compartilhar suas senhas \n "
				+ "- Alterar as senhas padrões e usar senhas fortes \n - Utilizar softwares do catálogo da Seção de Informática \n "
				+ "- Não faça uso de NENHUMA outra rede, além da EBNet \n - Não modificar configurações administrativas do computador \n "
				+ "- Comunicar qualquer incidente de segurança imediatamente a Seção de Informática \n"
				+ "- Os PCs verificados pela Seção de Informática possuem etiqueta padrão, lacres, \n  papel de parede com a logo da OM e bloqueios diversos que impedem mudanças no sistema. \n"
				+ "- Todos computadores devem obecer os padrões estabelecidos pela Seção de Informática. \n Em caso de dúvida, procure a Seção de Informática para regularizar seu equipamento.";

		return message;
	}
}
