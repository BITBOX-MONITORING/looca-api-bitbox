import com.github.britooo.looca.api.core.Looca;
import com.github.britooo.looca.api.group.discos.Disco;
import com.github.britooo.looca.api.group.discos.DiscoGrupo;
import com.github.britooo.looca.api.group.memoria.Memoria;
import com.github.britooo.looca.api.group.processador.Processador;
import com.github.britooo.looca.api.group.processos.Processo;
import com.github.britooo.looca.api.group.processos.ProcessoGrupo;
import com.github.britooo.looca.api.group.rede.Rede;
import com.github.britooo.looca.api.group.rede.RedeInterface;
import com.github.britooo.looca.api.group.rede.RedeInterfaceGroup;
import com.github.britooo.looca.api.group.rede.RedeParametros;
import com.github.britooo.looca.api.group.servicos.Servico;
import com.github.britooo.looca.api.group.servicos.ServicoGrupo;
import com.github.britooo.looca.api.group.sistema.Sistema;
import com.github.britooo.looca.api.group.temperatura.Temperatura;

import java.util.List;



public class looca {

    public static void main(String[] args) {
        Looca looca = new Looca();

          Memoria memoria = looca.getMemoria();
          Processador processador =  looca.getProcessador();
          Temperatura temperatura =  looca.getTemperatura();
          ServicoGrupo grupoDeServicos =  looca.getGrupoDeServicos();
          ProcessoGrupo grupoDeProcessos =  looca.getGrupoDeProcessos();
          Rede rede = looca.getRede();
          RedeInterfaceGroup redeInterface = rede.getGrupoDeInterfaces();
          List<RedeInterface> redesIntefaces = redeInterface.getInterfaces();
        RedeParametros redeParametros = rede.getParametros();

        Sistema sistema = looca.getSistema();
        //Criação do gerenciador
        DiscoGrupo grupoDeDiscos = looca.getGrupoDeDiscos();

        //Obtendo lista de discos a partir do getter
        List<Disco> discos = grupoDeDiscos.getDiscos();

        List<Servico> servicos = grupoDeServicos.getServicos();
        List<Processo> processos = grupoDeProcessos.getProcessos();

        servicos.forEach(e -> System.out.println(e));
        discos.forEach(e -> System.out.println(e));
        processos.forEach(e -> System.out.println(e));
        redesIntefaces.forEach(e -> System.out.println(e));
        Long porcentagemDaMemoriaRam = (memoria.getEmUso() * 100) / memoria.getTotal();
        System.out.println(memoria);
        System.out.println(processador);
        System.out.println(temperatura);
        System.out.println(redeParametros);
        System.out.println("Memoria ram em uso %:" + porcentagemDaMemoriaRam);

        for (int i = 0; i < discos.size(); i++) {
            var discoAtual = discos.get(i);

            System.out.println("Tamanho do disco em GB: " + discoAtual.getTamanho() / 1073741824);
            System.out.println("Leitura atual em KB/S: " + discoAtual.getBytesDeLeitura() / 1024);
        }

        System.out.println(sistema);

    }

}
