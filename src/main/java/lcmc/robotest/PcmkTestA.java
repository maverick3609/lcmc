/*
 * This file is part of LCMC written by Rasto Levrinc.
 *
 * Copyright (C) 2013, Rastislav Levrinc.
 *
 * The LCMC is free software; you can redistribute it and/or
 * modify it under the terms of the GNU General Public License as published
 * by the Free Software Foundation; either version 2, or (at your option)
 * any later version.
 *
 * The LCMC is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with LCMC; see the file COPYING.  If not, write to
 * the Free Software Foundation, 675 Mass Ave, Cambridge, MA 02139, USA.
 */

package lcmc.robotest;

import lcmc.utilities.Tools;
import java.awt.event.KeyEvent;
import static lcmc.robotest.RoboTest.*;

/**
 * This class is used to test the GUI.
 *
 * @author Rasto Levrinc
 */
final class PcmkTestA {

    /** Private constructor, cannot be instantiated. */
    private PcmkTestA() {
        /* Cannot be instantiated. */
    }

    static void start(final int count) {
        slowFactor = 0.5f;
        aborted = false;
        disableStonith();
        final int gx = 235;
        final int gy = 207;
        for (int i = count; i > 0; i--) {
            if (i % 5 == 0) {
                info("testA I: " + i);
            }
            checkTest("testA", 1);
            /* group with dummy resources */
            moveTo(gx, gy);
            rightClick(); /* popup */
            moveTo(Tools.getString("ClusterBrowser.Hb.AddGroup"));
            leftClick();
            /* create dummy */
            moveTo(gx + 46, gy + 11);
            rightClick(); /* group popup */
            moveTo(Tools.getString("ClusterBrowser.Hb.AddGroupService"));
            moveTo("OCF Resource Agents");
            typeDummy();
            setTimeouts(true);
            moveTo(Tools.getString("Browser.ApplyResource"));
            leftClick();
            checkTest("testA", 2);
            stopResource(gx, gy);
            checkTest("testA", 3);

            /* copy/paste */
            moveTo(gx + 10 , gy + 10);
            leftClick();
            robot.keyPress(KeyEvent.VK_CONTROL);
            press(KeyEvent.VK_C);
            press(KeyEvent.VK_V);
            robot.keyRelease(KeyEvent.VK_CONTROL);
            moveTo(gx + 10 , gy + 90);
            leftClick();
            moveTo(Tools.getString("Browser.ApplyGroup"));
            leftClick();
            checkTest("testA", 4);

            removeResource(gx, gy, CONFIRM_REMOVE);
            removeResource(gx, gy + 90, CONFIRM_REMOVE);
            resetTerminalAreas();
        }
        System.gc();
    }
}
