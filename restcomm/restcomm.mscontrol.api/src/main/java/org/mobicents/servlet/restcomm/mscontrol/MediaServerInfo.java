/*
 * TeleStax, Open Source Cloud Communications
 * Copyright 2011-2013, Telestax Inc and individual contributors
 * by the @authors tag.
 *
 * This is free software; you can redistribute it and/or modify it
 * under the terms of the GNU Lesser General Public License as
 * published by the Free Software Foundation; either version 2.1 of
 * the License, or (at your option) any later version.
 *
 * This software is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public
 * License along with this software; if not, write to the Free
 * Software Foundation, Inc., 51 Franklin St, Fifth Floor, Boston, MA
 * 02110-1301 USA, or see the FSF site: http://www.fsf.org.
 */

package org.mobicents.servlet.restcomm.mscontrol;

import java.net.InetAddress;

import org.mobicents.servlet.restcomm.annotations.concurrency.Immutable;

/**
 * @author Henrique Rosa (henrique.rosa@telestax.com)
 *
 */
@Immutable
public final class MediaServerInfo {

    private final String name;
    private final InetAddress address;
    private final int port;
    private final int timeout;

    public MediaServerInfo(String name, InetAddress address, int port, int timeout) {
        super();
        this.name = name;
        this.address = address;
        this.port = port;
        this.timeout = timeout;
    }

    public String getName() {
        return name;
    }

    public InetAddress getAddress() {
        return address;
    }

    public int getPort() {
        return port;
    }

    public int getTimeout() {
        return timeout;
    }

}