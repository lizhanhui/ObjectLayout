/*
 * Written by Gil Tene, and released to the public domain,
 * as explained at http://creativecommons.org/publicdomain/zero/1.0/
 */

import org.ObjectLayout.Intrinsic;
import org.ObjectLayout.IntrinsicObjects;

import java.util.concurrent.atomic.AtomicLong;

/**
 * A simple Line class example with two intrinsic Point end point objects. Demonstrates use of
 * {@link org.ObjectLayout.Intrinsic} and {@link org.ObjectLayout.IntrinsicObjects}
 *
 */
public class SimpleLine {
    /**
     * Simple intrinsic object declaration and initialization:
     */
    @Intrinsic
    private final Point endPoint1 = IntrinsicObjects.constructWithin("endPoint1", this);
    @Intrinsic
    private final Point endPoint2 = IntrinsicObjects.constructWithin("endPoint2", this);

    /**
     * Use of makeIntrinsicObjectsAccessible in initializer (useful if no constructors exist, for example):
     */
    {
        IntrinsicObjects.makeIntrinsicObjectsAccessible(this);
    }

    public SimpleLine() {
        this(0, 0, 0, 0);
    }

    public SimpleLine(final long x1, final long y1, long x2, long y2) {
        this.endPoint1.set(x1, y1);
        this.endPoint1.set(x2, y2);
    }

    public SimpleLine(final SimpleLine source) {
        this(source.endPoint1.getX(), source.endPoint1.getY(),
                source.endPoint2.getX(), source.endPoint2.getY());
    }

    public Point getEndPoint1() {
        return endPoint1;
    }

    public Point getEndPoint2() {
        return endPoint2;
    }
}
