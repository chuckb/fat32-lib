/*
 * $Id: AbstractFileSystem.java 4975 2009-02-02 08:30:52Z lsantha $
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
 
package com.meetwise.fs;

import java.io.IOException;

/**
 * Abstract class with common things in different FileSystem implementations.
 * 
 * @author Fabien DUMINY
 * @author Matthias Treydte &lt;waldheinz at gmail.com&gt;
 */
public abstract class AbstractFileSystem implements FileSystem {
    private final boolean readOnly;
    private boolean closed;
    
    /**
     * Constructs an {@code AbstractFileSystem} in specified readOnly mode. If
     * the specified {@code device} is read-only, only a read-only file system
     * can be created on top of it.
     * 
     * @param readOnly if the file system should be read-only.
     */
    public AbstractFileSystem(boolean readOnly) {
        
        this.closed = false;
        this.readOnly = readOnly;
    }
    
    @Override
    public void close() throws IOException {
        if (!isClosed()) {
            if (!isReadOnly()) {
                flush();
            }
            
            closed = true;
        }
    }
    
    @Override
    public final boolean isClosed() {
        return closed;
    }
    
    @Override
    public final boolean isReadOnly() {
        return readOnly;
    }

    /**
     * Checks if this {@code FileSystem} was already closed, and throws an
     * exception if it was.
     *
     * @throws IllegalStateException if this {@code FileSystem} was
     *      already closed
     */
    protected final void checkClosed() throws IllegalStateException {
        if (isClosed()) {
            throw new IllegalStateException("file system was already closed");
        }
    }
}
