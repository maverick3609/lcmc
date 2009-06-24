/*
 * This file is part of DRBD Management Console by LINBIT HA-Solutions GmbH
 * written by Rasto Levrinc.
 *
 * Copyright (C) 2009, LINBIT HA-Solutions GmbH.
 *
 * DRBD Management Console is free software; you can redistribute it and/or
 * modify it under the terms of the GNU General Public License as published
 * by the Free Software Foundation; either version 2, or (at your option)
 * any later version.
 *
 * DRBD Management Console is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with drbd; see the file COPYING.  If not, write to
 * the Free Software Foundation, 675 Mass Ave, Cambridge, MA 02139, USA.
 */


package drbd.gui.dialog;

import drbd.data.Cluster;

/**
 * An implementation of an dialog with log files from many hosts.
 *
 * @author Rasto Levrinc
 * @version $Id$
 */
public class ClusterDrbdLogs extends ClusterLogs {
    /** Serial version UUID. */
    private static final long serialVersionUID = 1L;
    /** Name of the drbd device. */
    private final String deviceName;

    /**
     * Prepares a new <code>ClusterDrbdLogs</code> object.
     */
    public ClusterDrbdLogs(final Cluster cluster, final String device) {
        super(cluster);
        deviceName = device.substring(device.lastIndexOf('/') + 1) + ":";
    }

    /**
     * Returns command string (defined in Distresource...) that prints the drbd
     * log.
     */
    protected final String logFileCommand() {
        return "DrbdLog.log";
    }

    /**
     * Returns pattern that will be greped in the log.
     */
    protected final String grepPattern() {
        return deviceName;
    }
}
