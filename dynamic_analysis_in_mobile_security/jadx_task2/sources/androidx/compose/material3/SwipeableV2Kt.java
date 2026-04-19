package androidx.compose.material3;

import androidx.autofill.HintConstants;
import androidx.compose.animation.core.AnimationSpec;
import androidx.compose.foundation.gestures.DraggableKt;
import androidx.compose.foundation.gestures.Orientation;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.saveable.RememberSaveableKt;
import androidx.compose.runtime.saveable.Saver;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.platform.InspectableValueKt;
import androidx.compose.ui.platform.InspectorInfo;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.IntSize;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: compiled from: SwipeableV2.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000z\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\"\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\u001aC\u0010\u0000\u001a(\u0012\u0004\u0012\u00020\u0002\u0012\u0013\u0012\u00110\u0003¢\u0006\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0006\u0012\u0004\u0012\u00020\u00030\u0001¢\u0006\u0002\b\u00072\u0006\u0010\b\u001a\u00020\tH\u0001ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\n\u0010\u000b\u001a6\u0010\f\u001a(\u0012\u0004\u0012\u00020\u0002\u0012\u0013\u0012\u00110\u0003¢\u0006\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0006\u0012\u0004\u0012\u00020\u00030\u0001¢\u0006\u0002\b\u00072\u0006\u0010\r\u001a\u00020\u0003H\u0001\u001aZ\u0010\u000e\u001a\b\u0012\u0004\u0012\u0002H\u00100\u000f\"\b\b\u0000\u0010\u0010*\u00020\u00112\u0006\u0010\u0012\u001a\u0002H\u00102\u000e\b\u0002\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00030\u00142#\b\u0002\u0010\u0015\u001a\u001d\u0012\u0013\u0012\u0011H\u0010¢\u0006\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0017\u0012\u0004\u0012\u00020\u00180\u0016H\u0001¢\u0006\u0002\u0010\u0019\u001a7\u0010\u001a\u001a\u0002H\u0010\"\u0004\b\u0000\u0010\u0010*\u000e\u0012\u0004\u0012\u0002H\u0010\u0012\u0004\u0012\u00020\u00030\u001b2\b\b\u0002\u0010\u001c\u001a\u00020\u00032\b\b\u0002\u0010\u001d\u001a\u00020\u0018H\u0002¢\u0006\u0002\u0010\u001e\u001a%\u0010\u001f\u001a\u0004\u0018\u00010\u0003\"\u0004\b\u0000\u0010\u0010*\u000e\u0012\u0004\u0012\u0002H\u0010\u0012\u0004\u0012\u00020\u00030\u001bH\u0002¢\u0006\u0002\u0010 \u001a%\u0010!\u001a\u0004\u0018\u00010\u0003\"\u0004\b\u0000\u0010\u0010*\u000e\u0012\u0004\u0012\u0002H\u0010\u0012\u0004\u0012\u00020\u00030\u001bH\u0002¢\u0006\u0002\u0010 \u001a}\u0010\"\u001a\u00020#\"\u0004\b\u0000\u0010\u0010*\u00020#2\f\u0010$\u001a\b\u0012\u0004\u0012\u0002H\u00100\u000f2\f\u0010%\u001a\b\u0012\u0004\u0012\u0002H\u00100&2\u0010\b\u0002\u0010'\u001a\n\u0012\u0004\u0012\u0002H\u0010\u0018\u00010(28\u0010)\u001a4\u0012\u0013\u0012\u0011H\u0010¢\u0006\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(*\u0012\u0013\u0012\u00110+¢\u0006\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(,\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u0001H\u0001ø\u0001\u0001\u001aH\u0010-\u001a\u00020#\"\u0004\b\u0000\u0010\u0010*\u00020#2\f\u0010$\u001a\b\u0012\u0004\u0012\u0002H\u00100\u000f2\u0006\u0010.\u001a\u00020/2\b\b\u0002\u00100\u001a\u00020\u00182\b\b\u0002\u00101\u001a\u00020\u00182\n\b\u0002\u00102\u001a\u0004\u0018\u000103H\u0001\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b\u0019¨\u00064"}, d2 = {"fixedPositionalThreshold", "Lkotlin/Function2;", "Landroidx/compose/ui/unit/Density;", "", "Lkotlin/ParameterName;", HintConstants.AUTOFILL_HINT_NAME, "distance", "Lkotlin/ExtensionFunctionType;", "threshold", "Landroidx/compose/ui/unit/Dp;", "fixedPositionalThreshold-0680j_4", "(F)Lkotlin/jvm/functions/Function2;", "fractionalPositionalThreshold", "fraction", "rememberSwipeableV2State", "Landroidx/compose/material3/SwipeableV2State;", "T", "", "initialValue", "animationSpec", "Landroidx/compose/animation/core/AnimationSpec;", "confirmValueChange", "Lkotlin/Function1;", "newValue", "", "(Ljava/lang/Object;Landroidx/compose/animation/core/AnimationSpec;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;II)Landroidx/compose/material3/SwipeableV2State;", "closestAnchor", "", "offset", "searchUpwards", "(Ljava/util/Map;FZ)Ljava/lang/Object;", "maxOrNull", "(Ljava/util/Map;)Ljava/lang/Float;", "minOrNull", "swipeAnchors", "Landroidx/compose/ui/Modifier;", "state", "possibleValues", "", "anchorChangeHandler", "Landroidx/compose/material3/AnchorChangeHandler;", "calculateAnchor", "value", "Landroidx/compose/ui/unit/IntSize;", "layoutSize", "swipeableV2", "orientation", "Landroidx/compose/foundation/gestures/Orientation;", "enabled", "reverseDirection", "interactionSource", "Landroidx/compose/foundation/interaction/MutableInteractionSource;", "material3_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class SwipeableV2Kt {
    public static /* synthetic */ Modifier swipeableV2$default(Modifier modifier, SwipeableV2State swipeableV2State, Orientation orientation, boolean z, boolean z2, MutableInteractionSource mutableInteractionSource, int i, Object obj) {
        if ((i & 4) != 0) {
            z = true;
        }
        boolean z3 = z;
        if ((i & 8) != 0) {
            z2 = false;
        }
        boolean z4 = z2;
        if ((i & 16) != 0) {
            mutableInteractionSource = null;
        }
        return swipeableV2(modifier, swipeableV2State, orientation, z3, z4, mutableInteractionSource);
    }

    public static final <T> Modifier swipeableV2(Modifier modifier, SwipeableV2State<T> state, Orientation orientation, boolean z, boolean z2, MutableInteractionSource mutableInteractionSource) {
        Intrinsics.checkNotNullParameter(modifier, "<this>");
        Intrinsics.checkNotNullParameter(state, "state");
        Intrinsics.checkNotNullParameter(orientation, "orientation");
        return DraggableKt.draggable(modifier, state.getSwipeDraggableState(), orientation, (188 & 4) != 0 ? true : z, (188 & 8) != 0 ? null : mutableInteractionSource, (188 & 16) != 0 ? false : state.isAnimationRunning(), (188 & 32) != 0 ? new DraggableKt.C01541(null) : null, (188 & 64) != 0 ? new DraggableKt.AnonymousClass2(null) : new C03501(state, null), (188 & 128) != 0 ? false : z2);
    }

    /* JADX INFO: renamed from: androidx.compose.material3.SwipeableV2Kt$swipeableV2$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: SwipeableV2.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u008a@"}, d2 = {"<anonymous>", "", "T", "Lkotlinx/coroutines/CoroutineScope;", "velocity", ""}, k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "androidx.compose.material3.SwipeableV2Kt$swipeableV2$1", f = "SwipeableV2.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    static final class C03501 extends SuspendLambda implements Function3<CoroutineScope, Float, Continuation<? super Unit>, Object> {
        final /* synthetic */ SwipeableV2State<T> $state;
        /* synthetic */ float F$0;
        private /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C03501(SwipeableV2State<T> swipeableV2State, Continuation<? super C03501> continuation) {
            super(3, continuation);
            this.$state = swipeableV2State;
        }

        @Override // kotlin.jvm.functions.Function3
        public /* bridge */ /* synthetic */ Object invoke(CoroutineScope coroutineScope, Float f, Continuation<? super Unit> continuation) {
            return invoke(coroutineScope, f.floatValue(), continuation);
        }

        public final Object invoke(CoroutineScope coroutineScope, float f, Continuation<? super Unit> continuation) {
            C03501 c03501 = new C03501(this.$state, continuation);
            c03501.L$0 = coroutineScope;
            c03501.F$0 = f;
            return c03501.invokeSuspend(Unit.INSTANCE);
        }

        /* JADX INFO: renamed from: androidx.compose.material3.SwipeableV2Kt$swipeableV2$1$1, reason: invalid class name and collision with other inner class name */
        /* JADX INFO: compiled from: SwipeableV2.kt */
        @Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\u00020\u0003H\u008a@"}, d2 = {"<anonymous>", "", "T", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
        @DebugMetadata(c = "androidx.compose.material3.SwipeableV2Kt$swipeableV2$1$1", f = "SwipeableV2.kt", i = {}, l = {91}, m = "invokeSuspend", n = {}, s = {})
        static final class C00681 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
            final /* synthetic */ SwipeableV2State<T> $state;
            final /* synthetic */ float $velocity;
            int label;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            C00681(SwipeableV2State<T> swipeableV2State, float f, Continuation<? super C00681> continuation) {
                super(2, continuation);
                this.$state = swipeableV2State;
                this.$velocity = f;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                return new C00681(this.$state, this.$velocity, continuation);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                return ((C00681) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
            }

            /* JADX WARN: Type inference fix 'apply assigned field type' failed
            java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$PrimitiveArg
            	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:593)
            	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
            	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
            	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
            	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
            	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
            	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
             */
            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) {
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                int i = this.label;
                if (i == 0) {
                    ResultKt.throwOnFailure(obj);
                    this.label = 1;
                    if (this.$state.settle(this.$velocity, this) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.throwOnFailure(obj);
                }
                return Unit.INSTANCE;
            }
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            BuildersKt__Builders_commonKt.launch$default((CoroutineScope) this.L$0, null, null, new C00681(this.$state, this.F$0, null), 3, null);
            return Unit.INSTANCE;
        }
    }

    public static /* synthetic */ Modifier swipeAnchors$default(Modifier modifier, SwipeableV2State swipeableV2State, Set set, AnchorChangeHandler anchorChangeHandler, Function2 function2, int i, Object obj) {
        if ((i & 4) != 0) {
            anchorChangeHandler = null;
        }
        return swipeAnchors(modifier, swipeableV2State, set, anchorChangeHandler, function2);
    }

    public static final <T> Modifier swipeAnchors(Modifier modifier, final SwipeableV2State<T> state, final Set<? extends T> possibleValues, final AnchorChangeHandler<T> anchorChangeHandler, final Function2<? super T, ? super IntSize, Float> calculateAnchor) {
        Intrinsics.checkNotNullParameter(modifier, "<this>");
        Intrinsics.checkNotNullParameter(state, "state");
        Intrinsics.checkNotNullParameter(possibleValues, "possibleValues");
        Intrinsics.checkNotNullParameter(calculateAnchor, "calculateAnchor");
        return modifier.then(new SwipeAnchorsModifier(new Function1<Density, Unit>() { // from class: androidx.compose.material3.SwipeableV2Kt.swipeAnchors.1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Density density) {
                invoke2(density);
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Density it) {
                Intrinsics.checkNotNullParameter(it, "it");
                state.setDensity$material3_release(it);
            }
        }, new Function1<IntSize, Unit>() { // from class: androidx.compose.material3.SwipeableV2Kt.swipeAnchors.2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(IntSize intSize) {
                m1491invokeozmzZPI(intSize.getPackedValue());
                return Unit.INSTANCE;
            }

            /* JADX WARN: Type inference incomplete: some casts might be missing */
            /* JADX INFO: renamed from: invoke-ozmzZPI, reason: not valid java name */
            public final void m1491invokeozmzZPI(long j) {
                AnchorChangeHandler<T> anchorChangeHandler2;
                Map anchors$material3_release = state.getAnchors$material3_release();
                LinkedHashMap linkedHashMap = new LinkedHashMap();
                Iterable iterable = possibleValues;
                Function2<T, IntSize, Float> function2 = calculateAnchor;
                for (Object obj : iterable) {
                    Float fInvoke = function2.invoke((T) obj, IntSize.m5025boximpl(j));
                    if (fInvoke != null) {
                        linkedHashMap.put(obj, fInvoke);
                    }
                }
                if (Intrinsics.areEqual(anchors$material3_release, linkedHashMap)) {
                    return;
                }
                Object targetValue = state.getTargetValue();
                if (!state.updateAnchors$material3_release(linkedHashMap) || (anchorChangeHandler2 = anchorChangeHandler) == 0) {
                    return;
                }
                anchorChangeHandler2.onAnchorsChanged((T) targetValue, (Map<T, Float>) anchors$material3_release, linkedHashMap);
            }
        }, InspectableValueKt.isDebugInspectorInfoEnabled() ? new Function1<InspectorInfo, Unit>() { // from class: androidx.compose.material3.SwipeableV2Kt$swipeAnchors$$inlined$debugInspectorInfo$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(InspectorInfo inspectorInfo) {
                invoke2(inspectorInfo);
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(InspectorInfo inspectorInfo) {
                Intrinsics.checkNotNullParameter(inspectorInfo, "$this$null");
                inspectorInfo.setName("swipeAnchors");
                inspectorInfo.getProperties().set("state", state);
                inspectorInfo.getProperties().set("possibleValues", possibleValues);
                inspectorInfo.getProperties().set("anchorChangeHandler", anchorChangeHandler);
                inspectorInfo.getProperties().set("calculateAnchor", calculateAnchor);
            }
        } : InspectableValueKt.getNoInspectorInfo()));
    }

    public static final <T> SwipeableV2State<T> rememberSwipeableV2State(final T initialValue, final AnimationSpec<Float> animationSpec, final Function1<? super T, Boolean> function1, Composer composer, int i, int i2) {
        Intrinsics.checkNotNullParameter(initialValue, "initialValue");
        composer.startReplaceableGroup(856267266);
        ComposerKt.sourceInformation(composer, "C(rememberSwipeableV2State)P(2)522@21823L698:SwipeableV2.kt#uh7d8r");
        if ((i2 & 2) != 0) {
            animationSpec = SwipeableV2Defaults.INSTANCE.getAnimationSpec();
        }
        if ((i2 & 4) != 0) {
            function1 = new Function1<T, Boolean>() { // from class: androidx.compose.material3.SwipeableV2Kt.rememberSwipeableV2State.1
                /* JADX WARN: Can't rename method to resolve collision */
                @Override // kotlin.jvm.functions.Function1
                public final Boolean invoke(T it) {
                    Intrinsics.checkNotNullParameter(it, "it");
                    return true;
                }
            };
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(856267266, i, -1, "androidx.compose.material3.rememberSwipeableV2State (SwipeableV2.kt:517)");
        }
        SwipeableV2State<T> swipeableV2State = (SwipeableV2State) RememberSaveableKt.m2276rememberSaveable(new Object[]{initialValue, animationSpec, function1}, (Saver) SwipeableV2State.INSTANCE.m1493SavereqLRuRQ(animationSpec, function1, SwipeableV2Defaults.INSTANCE.getPositionalThreshold(), SwipeableV2Defaults.INSTANCE.m1489getVelocityThresholdD9Ej5fM()), (String) null, (Function0) new Function0<SwipeableV2State<T>>() { // from class: androidx.compose.material3.SwipeableV2Kt.rememberSwipeableV2State.2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final SwipeableV2State<T> invoke() {
                return new SwipeableV2State<>(initialValue, animationSpec, function1, SwipeableV2Defaults.INSTANCE.getPositionalThreshold(), SwipeableV2Defaults.INSTANCE.m1489getVelocityThresholdD9Ej5fM(), null);
            }
        }, composer, 72, 4);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return swipeableV2State;
    }

    /* JADX INFO: renamed from: fixedPositionalThreshold-0680j_4, reason: not valid java name */
    public static final Function2<Density, Float, Float> m1490fixedPositionalThreshold0680j_4(final float f) {
        return new Function2<Density, Float, Float>() { // from class: androidx.compose.material3.SwipeableV2Kt$fixedPositionalThreshold$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Float invoke(Density density, Float f2) {
                return invoke(density, f2.floatValue());
            }

            public final Float invoke(Density density, float f2) {
                Intrinsics.checkNotNullParameter(density, "$this$null");
                return Float.valueOf(density.mo325toPx0680j_4(f));
            }
        };
    }

    public static final Function2<Density, Float, Float> fractionalPositionalThreshold(final float f) {
        return new Function2<Density, Float, Float>() { // from class: androidx.compose.material3.SwipeableV2Kt.fractionalPositionalThreshold.1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(2);
            }

            public final Float invoke(Density density, float f2) {
                Intrinsics.checkNotNullParameter(density, "$this$null");
                return Float.valueOf(f2 * f);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Float invoke(Density density, Float f2) {
                return invoke(density, f2.floatValue());
            }
        };
    }

    static /* synthetic */ Object closestAnchor$default(Map map, float f, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            f = 0.0f;
        }
        if ((i & 2) != 0) {
            z = false;
        }
        return closestAnchor(map, f, z);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final <T> T closestAnchor(Map<T, Float> map, float f, boolean z) {
        if (!(!map.isEmpty())) {
            throw new IllegalArgumentException("The anchors were empty when trying to find the closest anchor".toString());
        }
        Iterator<T> it = map.entrySet().iterator();
        if (!it.hasNext()) {
            throw new NoSuchElementException();
        }
        T next = it.next();
        if (it.hasNext()) {
            float fFloatValue = ((Number) ((Map.Entry) next).getValue()).floatValue();
            float f2 = z ? fFloatValue - f : f - fFloatValue;
            if (f2 < 0.0f) {
                f2 = Float.POSITIVE_INFINITY;
            }
            do {
                T next2 = it.next();
                float fFloatValue2 = ((Number) ((Map.Entry) next2).getValue()).floatValue();
                float f3 = z ? fFloatValue2 - f : f - fFloatValue2;
                if (f3 < 0.0f) {
                    f3 = Float.POSITIVE_INFINITY;
                }
                if (Float.compare(f2, f3) > 0) {
                    next = next2;
                    f2 = f3;
                }
            } while (it.hasNext());
        }
        return (T) ((Map.Entry) next).getKey();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final <T> Float minOrNull(Map<T, Float> map) {
        Iterator<T> it = map.entrySet().iterator();
        if (!it.hasNext()) {
            return null;
        }
        float fFloatValue = ((Number) ((Map.Entry) it.next()).getValue()).floatValue();
        while (it.hasNext()) {
            fFloatValue = Math.min(fFloatValue, ((Number) ((Map.Entry) it.next()).getValue()).floatValue());
        }
        return Float.valueOf(fFloatValue);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final <T> Float maxOrNull(Map<T, Float> map) {
        Iterator<T> it = map.entrySet().iterator();
        if (!it.hasNext()) {
            return null;
        }
        float fFloatValue = ((Number) ((Map.Entry) it.next()).getValue()).floatValue();
        while (it.hasNext()) {
            fFloatValue = Math.max(fFloatValue, ((Number) ((Map.Entry) it.next()).getValue()).floatValue());
        }
        return Float.valueOf(fFloatValue);
    }
}
