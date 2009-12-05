package org.graniteds.tide.module
{
    import mx.logging.Log;
    import mx.logging.targets.TraceTarget;
    
    import org.granite.tide.ITideModule;
    import org.granite.tide.Tide;
    import org.granite.tide.validators.ValidatorExceptionHandler;
    import org.graniteds.tide.controller.AlbumController;
    import org.graniteds.tide.controller.ArtistController;
    import org.graniteds.tide.controller.LoginController;
    import org.graniteds.tide.controller.MainController;
    import org.graniteds.tide.controller.MainUIController;
    import org.graniteds.tide.exception.AccessDeniedExceptionHandler;
    import org.graniteds.tide.exception.NotLoggedInExceptionHandler;
    import org.graniteds.tide.exception.OptimisticLockExceptionHandler;
    import org.graniteds.tide.exception.SecurityExceptionHandler;
    import org.graniteds.tide.exception.ServerExceptionHandler;
    
    
    [Bindable]
    public class MainModule implements ITideModule {
        
        public function init(tide:Tide):void {
        	
			
        	var t:TraceTarget = new TraceTarget();
            t.filters = ["org.granite.*"];
            Log.addTarget(t);
            
           	tide.addExceptionHandler(ServerExceptionHandler);
           	tide.addExceptionHandler(AccessDeniedExceptionHandler);
           	tide.addExceptionHandler(NotLoggedInExceptionHandler);
           	tide.addExceptionHandler(OptimisticLockExceptionHandler);
           	tide.addExceptionHandler(SecurityExceptionHandler);
           	
			tide.addExceptionHandler(ValidatorExceptionHandler);
           	
           	tide.addComponent("mainController", MainController, false, true, Tide.RESTRICT_YES);
           	tide.addComponent("loginController", LoginController, false, true, Tide.RESTRICT_YES);
           	tide.addComponent("albumController", AlbumController, false, true, Tide.RESTRICT_YES);
           	tide.addComponent("artistController", ArtistController, false, true, Tide.RESTRICT_YES);
			tide.addComponent("mainUIController", MainUIController,false,true,Tide.RESTRICT_YES);
            
        }
    }
}
