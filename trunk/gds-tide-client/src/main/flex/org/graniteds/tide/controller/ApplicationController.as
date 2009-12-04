package org.graniteds.tide.controller
{
	import org.granite.tide.Tide;
	import org.granite.tide.spring.Context;
	import org.granite.tide.spring.Spring;
	import org.graniteds.tide.module.MainModule;
	
	public class ApplicationController
	{
		public static var tideContext:Context;
		
		public function ApplicationController()
		{
		}
		
		public static function preinitialize ():void {
			Spring.getInstance().initApplication();
		}
		
		public static function init():void {
			tideContext = Spring.getInstance().getSpringContext();
			var tide:Tide = Tide.getInstance();
			
			//Spring.getInstance().addExceptionHandler(ServerExceptionHandler);
            
           	Spring.getInstance().addModule(MainModule);
		}

	}
}
