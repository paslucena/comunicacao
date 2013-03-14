package comunicacao;

public class Conversao {

	private byte[] sendData;
	public Conversao(byte bytesDoArquivo){
		sendData = new byte[1034];
	}
	//ACK = byte[0]
	
	void setAck(byte ack){
		sendData[0] =  ack;
	}
}
