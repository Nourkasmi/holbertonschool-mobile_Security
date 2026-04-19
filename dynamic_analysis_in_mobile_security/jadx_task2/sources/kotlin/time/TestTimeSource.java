package kotlin.time;

import kotlin.Metadata;

/* JADX INFO: compiled from: TimeSources.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u001a\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0002ø\u0001\u0000¢\u0006\u0004\b\t\u0010\nJ\u001b\u0010\u000b\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0086\u0002ø\u0001\u0000¢\u0006\u0004\b\f\u0010\nJ\b\u0010\r\u001a\u00020\u0004H\u0014R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u000e"}, d2 = {"Lkotlin/time/TestTimeSource;", "Lkotlin/time/AbstractLongTimeSource;", "()V", "reading", "", "overflow", "", "duration", "Lkotlin/time/Duration;", "overflow-LRDsOJo", "(J)V", "plusAssign", "plusAssign-LRDsOJo", "read", "kotlin-stdlib"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class TestTimeSource extends AbstractLongTimeSource {
    private long reading;

    @Override // kotlin.time.AbstractLongTimeSource
    /* JADX INFO: renamed from: read, reason: from getter */
    protected long getReading() {
        return this.reading;
    }

    public TestTimeSource() {
        super(DurationUnit.NANOSECONDS);
        markNow();
    }

    /* JADX INFO: renamed from: plusAssign-LRDsOJo, reason: not valid java name */
    public final void m6622plusAssignLRDsOJo(long duration) {
        long jM6532toLongimpl = Duration.m6532toLongimpl(duration, getUnit());
        if (((jM6532toLongimpl - 1) | 1) != Long.MAX_VALUE) {
            long j = this.reading;
            long j2 = j + jM6532toLongimpl;
            if ((jM6532toLongimpl ^ j) >= 0 && (j ^ j2) < 0) {
                m6621overflowLRDsOJo(duration);
            }
            this.reading = j2;
            return;
        }
        long jM6489divUwyO8pc = Duration.m6489divUwyO8pc(duration, 2);
        if ((1 | (Duration.m6532toLongimpl(jM6489divUwyO8pc, getUnit()) - 1)) != Long.MAX_VALUE) {
            long j3 = this.reading;
            try {
                m6622plusAssignLRDsOJo(jM6489divUwyO8pc);
                m6622plusAssignLRDsOJo(Duration.m6521minusLRDsOJo(duration, jM6489divUwyO8pc));
                return;
            } catch (IllegalStateException e) {
                this.reading = j3;
                throw e;
            }
        }
        m6621overflowLRDsOJo(duration);
    }

    /* JADX INFO: renamed from: overflow-LRDsOJo, reason: not valid java name */
    private final void m6621overflowLRDsOJo(long duration) {
        throw new IllegalStateException("TestTimeSource will overflow if its reading " + this.reading + DurationUnitKt.shortName(getUnit()) + " is advanced by " + ((Object) Duration.m6535toStringimpl(duration)) + '.');
    }
}
