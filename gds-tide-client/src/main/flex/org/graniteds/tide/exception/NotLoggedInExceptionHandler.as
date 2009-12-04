package org.graniteds.tide.exception {
	import mx.controls.Alert;
	import mx.messaging.messages.ErrorMessage;
	
	import org.granite.tide.BaseContext;
	import org.granite.tide.IExceptionHandler;
	
	
    public class NotLoggedInExceptionHandler implements IExceptionHandler {
        
        public static const NOT_LOGGED_IN:String = "Server.Security.NotLoggedIn"; 
        
        
        public function accepts(emsg:ErrorMessage):Boolean {
            return emsg.faultCode == NOT_LOGGED_IN;
        }

        public function handle(context:BaseContext, emsg:ErrorMessage):void {
            Alert.show("Not authorized: You are not logged in");
        }
    }
}
