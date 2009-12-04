package org.graniteds.tide.exception
{
	import mx.controls.Alert;
	import mx.messaging.messages.ErrorMessage;
	
	import org.granite.tide.BaseContext;
	import org.granite.tide.IExceptionHandler;
	
	public class ServerExceptionHandler implements IExceptionHandler {

	    public function accepts(emsg:ErrorMessage):Boolean {
	        return true;
	    }
		
	    public function handle(context:BaseContext, emsg:ErrorMessage):void {
	        Alert.show("Erreur sur le serveur : \n" + 
	        		emsg.faultCode + "\n" + 
	        		emsg.faultDetail + "\n" +
	        		emsg.faultString);
	    }
	}
}