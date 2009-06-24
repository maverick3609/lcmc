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

package drbd.configs;

import java.util.Arrays;

/**
 * Here are commands for debian verson lenny.
 */
public class DistResource_debian_LENNY extends
            java.util.ListResourceBundle {

    /** Get contents. */
    protected final Object[][] getContents() {
        return Arrays.copyOf(contents, contents.length);
    }

    /** Contents. */
    private static Object[][] contents = {
        /* Kernel versions and their counterpart in @KERNELVERSION@ variable in
         * the donwload url. Must begin with "kernel:" keyword. deprecated */


        /* distribution name that is used in the download url */
        {"distributiondir", "debian-lenny"},

        /* support */
        // TODO: use flags for this
        {"Support", "debian-LENNY"},

        /* openais/pacemaker opensuse */
        {"AisPmInst.install.text.1", "http://download.opensuse.org repository"},

        {"AisPmInst.install.1",
         "echo 'deb http://download.opensuse.org/repositories/server:/ha-clustering/Debian_5.0/ ./'"
         + " > /etc/apt/sources.list.d/ha-clustering.list "
         + " && apt-get update"
         + " && apt-get -y -q  --allow-unauthenticated install"
         + " -o 'DPkg::Options::force=--force-confnew' openais pacemaker"
         + " && /usr/sbin/update-rc.d openais-legacy start 75 2 3 4 5 . stop 05 0 1 6 . "},

        /* openais/pacemaker madkiss */
        {"AisPmInst.install.text.2",
         "LINBIT/MADKISS repository (testing)"},

        {"AisPmInst.install.2",
         "echo 'deb http://people.debian.org/~madkiss/ha lenny main'"
         + " > /etc/apt/sources.list.d/ha-clustering.list "
         + " && apt-get update"
         + " && apt-get -y -q  --allow-unauthenticated install"
         + " -o 'DPkg::Options::force=--force-confnew' pacemaker-openais"},

        /* heartbeat/pacemaker opensuse */
        {"HbPmInst.install.text.1", "http://download.opensuse.org repository"},

        {"HbPmInst.install.1",
         "echo 'deb http://download.opensuse.org/repositories/server:/ha-clustering/Debian_5.0/ ./' > /etc/apt/sources.list.d/ha-clustering.list "
         + " && apt-get update"
         + " && apt-get -y -q  --allow-unauthenticated install"
         + " -o 'DPkg::Options::force=--force-confnew' heartbeat pacemaker"
         + " && /usr/sbin/update-rc.d heartbeat start 75 2 3 4 5 . stop 05 0 1 6 . "},

        /* heartbeat/pacemaker madkiss */
        {"HbPmInst.install.text.2",
         "LINBIT/MADKISS repository (testing: pacemaker-heartbeat)"},

        {"HbPmInst.install.2",
         "echo 'deb http://people.debian.org/~madkiss/ha lenny main' > /etc/apt/sources.list.d/ha-clustering.list "
         + " && apt-get update"
         + " && apt-get -y -q  --allow-unauthenticated install"
         + " -o 'DPkg::Options::force=--force-confnew' pacemaker-heartbeat"},

        /* heartbeat apt-get install */
        {"HbPmInst.install.text.3",
         "lenny repository (not recommended)"},

        {"HbPmInst.install.3",
         "apt-get update && "
         + "/usr/bin/apt-get -y -q install -o"
         + " 'DPkg::Options::force=--force-confnew' heartbeat-2"},
    };
}
