package org.graniteds.tide.exception {
	import mx.controls.Alert;
	import mx.messaging.messages.ErrorMessage;
	
	import org.granite.tide.BaseContext;
	import org.granite.tide.IExceptionHandler;
	
	
    public class AccessDeniedExceptionHandler implements IExceptionHandler {
        
        public static const ACCESS_DENIED:String = "Server.Security.AccessDenied"; 
        
        
        public function accepts(emsg:ErrorMessage):Boolean {
			return emsg.faultCode == ACCESS_DENIED;
        }
		
        public function handle(context:BaseContext, emsg:ErrorMessage):void {
            Alert.show("Not authorized: you don't have the required rights");
        }
    }
}
