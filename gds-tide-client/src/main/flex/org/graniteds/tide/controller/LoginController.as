package org.graniteds.tide.controller
{
	import mx.controls.Alert;
	
	import org.granite.tide.events.TideFaultEvent;
	import org.granite.tide.events.TideResultEvent;
	import org.granite.tide.spring.Context;
	import org.granite.tide.spring.Identity;
	import org.granite.tide.spring.Spring;
	import org.graniteds.tide.event.LoggedInEvent;
	import org.graniteds.tide.event.LoginEvent;
	
	[Name("loginController")]
	[Bindable]
	public class LoginController
	{
			[In]
	        public var loginUI:Object;
			[In]
			public var loginService:Object;
			[In]
			public var identity:Identity;
			
			[Observer]   
			public function walangLogin(event:LoginEvent):void {
				identity.login(loginUI.username.text, loginUI.password.text, loginResult, loginFault); 
			}
			
			[Observer('tawaginAngLogin')]
			public function walaLnag():void
			{
				//var ctx:Context = Spring.getInstance().getSpringContext();
				loginService.sayHello("emmanuel",handleSayHelloResult);
			}
			
			public function handleSayHelloResult(event:TideResultEvent):void
			{
				Alert.show(event.result.toString());
			}
			
			public function loginResult(event:TideResultEvent):void {
				loginUI.message = null;
				dispatchEvent(new LoggedInEvent());
			}
			   
			public function loginFault(event:TideFaultEvent):void {
				loginUI.message = event.fault.faultString;
			}
	}
					
}
