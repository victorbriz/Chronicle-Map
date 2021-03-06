/*
 * Copyright 2014 Higher Frequency Trading http://www.higherfrequencytrading.com
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package net.openhft.chronicle.hash.impl.util;

import org.jetbrains.annotations.NotNull;

public final class CharSequences {

    public static boolean equivalent(@NotNull CharSequence a, @NotNull CharSequence b) {
        if (a.equals(b))
            return true;
        if (a instanceof String)
            return ((String) a).contentEquals(b);
        if (b instanceof String)
            return ((String) b).contentEquals(a);
        int len = a.length();
        if (len != b.length())
            return false;
        for (int i = 0; i < len; i++) {
            if (a.charAt(i) != b.charAt(i))
                return false;
        }
        return true;
    }

    public static int hash(@NotNull CharSequence cs) {
        if (cs instanceof String)
            return cs.hashCode();
        int h = 0;
        for (int i = 0, len = cs.length(); i < len; i++) {
            h = 31 * h + cs.charAt(i);
        }
        return h;
    }

    private CharSequences() {}
}
