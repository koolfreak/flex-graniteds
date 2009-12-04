package org.graniteds.tide.exception {
	import mx.controls.Alert;
	import mx.messaging.messages.ErrorMessage;
	
	import org.granite.tide.BaseContext;
	import org.granite.tide.IExceptionHandler;
	
	
    public class OptimisticLockExceptionHandler implements IExceptionHandler {
        
        public static const OPTIMISTIC_LOCK:String = "Persistence.OptimisticLock"; 
                
        public function accepts(emsg:ErrorMessage):Boolean {
            return emsg.faultCode == OPTIMISTIC_LOCK;
        }

        public function handle(context:BaseContext, emsg:ErrorMessage):void {
            Alert.show("Another user has modified the entity during your changes.\nPlease retry.");
        }
    }
}
