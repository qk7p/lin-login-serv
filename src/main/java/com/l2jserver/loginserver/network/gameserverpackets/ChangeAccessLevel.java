/*
 * Copyright © 2004-2024 L2J Server
 * 
 * This file is part of L2J Server.
 * 
 * L2J Server is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 * 
 * L2J Server is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
 * General Public License for more details.
 * 
 * You should have received a copy of the GNU General Public License
 * along with this program. If not, see <http://www.gnu.org/licenses/>.
 */
package com.l2jserver.loginserver.network.gameserverpackets;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.l2jserver.commons.network.BaseRecievePacket;
import com.l2jserver.loginserver.GameServerThread;
import com.l2jserver.loginserver.LoginController;

/**
 * Change Access Level packet.
 * @author -Wooden-
 * @version 2.6.1.0
 */
public class ChangeAccessLevel extends BaseRecievePacket {
	
	private static final Logger LOG = LoggerFactory.getLogger(ChangeAccessLevel.class);
	
	public ChangeAccessLevel(byte[] decrypt, GameServerThread server) {
		super(decrypt);
		int level = readD();
		String account = readS();
		
		LoginController.getInstance().setAccountAccessLevel(account, level);
		LOG.info("Changed {} access level to {}.", account, level);
	}
}
