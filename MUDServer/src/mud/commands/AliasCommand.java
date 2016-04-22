package mud.commands;

import java.util.Map.Entry;

import mud.Command;
import mud.Constants;
import mud.MUDServer;
import mud.net.Client;

/*
 * Copyright (c) 2012 Jeremy N. Harton
 * 
 * Released under the MIT License:
 * LICENSE.txt, http://opensource.org/licenses/MIT
 * 
 * NOTE: license provided with code controls, if any
 * changes are made to the one referred to.
 */

public class AliasCommand extends Command {
	public AliasCommand() {
		super("");
	}
	
	@Override
	public void execute(String arg, Client client) {
		if ( arg.equals("#list") ) {
			send("Aliases", client);
			send("-------------------------------------------", client);
			for (final Entry<String, String> e : getAliases().entrySet()) {
				send(e.getKey() + " : " + e.getValue(), client);
			}
			send("-------------------------------------------", client);
		}
		else {
			// @alias command=alias string
			final String[] args = arg.split("=");
			
			if( args.length == 2 ) {
				// should we be making sure the specified command is valid
				addAlias(args[0], args[1]);
			}
			else {
				// if no set of things to alias to, just show existing aliases for it if any
			}
		}
	}

	@Override
	public int getAccessLevel() {
		return Constants.ADMIN;
	}
}