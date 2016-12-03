/*
 * This file is part of LCMC written by Rasto Levrinc.
 *
 * Copyright (C) 2016, Rastislav Levrinc.
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

package lcmc.common.ui.treemenu;

import lcmc.common.domain.util.Tools;
import lcmc.common.ui.CategoryInfo;
import lcmc.common.ui.utils.SwingUtils;

import javax.annotation.Resource;
import javax.inject.Inject;
import javax.inject.Named;
import javax.inject.Singleton;
import javax.swing.tree.DefaultMutableTreeNode;

@Named
@Singleton
public class EmptyTreeMenu extends TreeMenuController {
    @Resource(name="categoryInfo")
    private CategoryInfo resourcesCategory;

    @Inject
    public EmptyTreeMenu(final SwingUtils swingUtils) {
        super(swingUtils);
    }

    public final DefaultMutableTreeNode createMenuTreeTop() {
        resourcesCategory.init(Tools.getString("Browser.Resources"), null);
        return createMenuTreeTop(resourcesCategory);
    }
}