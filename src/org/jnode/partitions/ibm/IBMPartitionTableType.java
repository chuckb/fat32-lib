/*
 * $Id: IBMPartitionTableType.java 4975 2009-02-02 08:30:52Z lsantha $
 *
 * Copyright (C) 2003-2009 JNode.org
 *
 * This library is free software; you can redistribute it and/or modify it
 * under the terms of the GNU Lesser General Public License as published
 * by the Free Software Foundation; either version 2.1 of the License, or
 * (at your option) any later version.
 *
 * This library is distributed in the hope that it will be useful, but 
 * WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY
 * or FITNESS FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public 
 * License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public License
 * along with this library; If not, write to the Free Software Foundation, Inc., 
 * 51 Franklin Street, Fifth Floor, Boston, MA 02110-1301 USA.
 */
 
package org.jnode.partitions.ibm;

import org.jnode.driver.block.BlockDevice;
import org.jnode.partitions.PartitionTable;
import org.jnode.partitions.PartitionTableException;
import org.jnode.partitions.PartitionTableType;

/**
 * IBM partition table table.
 * 
 * @author Ewout Prangsma (epr@users.sourceforge.net)
 */
public class IBMPartitionTableType implements PartitionTableType {

    /**
     * @see org.jnode.partitions.PartitionTableType#create(org.jnode.driver.Device)
     */
    public PartitionTable<IBMPartitionTableEntry> create(
            byte[] firstSector, BlockDevice device) throws
            PartitionTableException {
        
        return new IBMPartitionTable(this, firstSector, device);
    }

    /**
     * @see org.jnode.partitions.PartitionTableType#getName()
     */
    public String getName() {
        return "IBM";
    }

    /**
     * @see org.jnode.partitions.PartitionTableType#supports(org.jnode.driver.block.BlockDevice)
     */
    public boolean supports(byte[] firstSector, BlockDevice devApi) {
        // TODO Make a suitable implementation
        return true;
    }
}
