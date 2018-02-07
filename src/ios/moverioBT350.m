#import "moverioBT350.h"

#import <Cordova/CDVAvailability.h>

@implementation moverioBT350

- (void)pluginInitialize {
}

- (void)saludar:(CDVInvokedUrlCommand*)command
{

    NSString* name = [[command arguments] objectAtIndex:0];
    NSString* msg = [NSString stringWithFormat: @"Hola todo el...  %@", name];

    CDVPluginResult* result = [CDVPluginResult
                               resultWithStatus:CDVCommandStatus_OK
                               messageAsString:msg];

    [self.commandDelegate sendPluginResult:result callbackId:command.callbackId];
}

@end
