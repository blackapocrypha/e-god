<template>
  <div class="item">
    <div class="icon-wrapper">
      <slot name="icon"></slot>
    </div>
    <div class="details">
      <h3 class="heading">
        <slot name="heading"></slot>
      </h3>
      <div class="content">
        <slot></slot>
      </div>
    </div>
  </div>
</template>

<style scoped>
.item {
  display: flex;
  gap: var(--space-md);
  padding: var(--space-lg);
  background: var(--color-bg-elevated);
  border: 1px solid var(--color-border-light);
  border-radius: var(--radius-lg);
  box-shadow: var(--shadow-sm);
  transition:
    box-shadow var(--duration-normal) var(--ease-out-quart),
    border-color var(--duration-normal) var(--ease-out-quart),
    transform var(--duration-normal) var(--ease-out-quart);
}

.item:hover {
  box-shadow: var(--shadow-md);
  border-color: var(--color-border-hover);
  transform: translateY(-1px);
}

.icon-wrapper {
  flex-shrink: 0;
  display: flex;
  align-items: center;
  justify-content: center;
  width: 44px;
  height: 44px;
  border-radius: var(--radius-md);
  background: var(--color-primary-light);
  color: var(--color-primary);
}

.icon-wrapper :deep(svg) {
  width: 22px;
  height: 22px;
}

.details {
  flex: 1;
  min-width: 0;
}

.heading {
  font-size: var(--text-base);
  font-weight: var(--weight-semibold);
  color: var(--color-text);
  margin-bottom: var(--space-sm);
  line-height: var(--leading-tight);
}

.heading :deep(a) {
  color: var(--color-primary);
  font-weight: var(--weight-medium);
}

.content {
  font-size: var(--text-sm);
  color: var(--color-text-soft);
  line-height: var(--leading-relaxed);
}

.content :deep(a) {
  color: var(--color-primary);
  text-decoration: underline;
  text-underline-offset: 2px;
}

@media (min-width: 1024px) {
  .item {
    margin-bottom: var(--space-md);
  }
}
</style>
