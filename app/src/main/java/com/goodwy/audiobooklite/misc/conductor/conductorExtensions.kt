package com.goodwy.audiobooklite.misc.conductor

import android.content.Context
import com.bluelinelabs.conductor.Controller
import com.bluelinelabs.conductor.ControllerChangeHandler
import com.bluelinelabs.conductor.RouterTransaction
import com.goodwy.audiobooklite.uitools.VerticalChangeHandler

// convenient way to setup a router transaction
fun Controller.asTransaction(
  pushChangeHandler: ControllerChangeHandler? = VerticalChangeHandler(),
  popChangeHandler: ControllerChangeHandler? = VerticalChangeHandler()
) = RouterTransaction.with(this).apply {
  pushChangeHandler?.let { pushChangeHandler(it) }
  popChangeHandler?.let { popChangeHandler(it) }
}

fun Controller.popOrBack() {
  val hasRemaining = router.popController(this)
  if (!hasRemaining) activity?.onBackPressed()
}

val Controller.context: Context get() = activity!!
