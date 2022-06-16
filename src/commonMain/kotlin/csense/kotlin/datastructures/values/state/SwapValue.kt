package csense.kotlin.datastructures.values.state

public open class SwapValue<T>(
    initial: T,
    secondaryState: T
) : Swappable<T> {

    override val value: T
        get() = states.value

    private val states = CircularStates(
        states = listOf(
            initial,
            secondaryState
        )
    )

    public override fun swap(): Unit = states.next()
}